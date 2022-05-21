package pageEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.PersonalData;
import utilities.Variables;

import java.util.ArrayList;

public class HotelReservation extends AbstractPage {
    WebDriver driver;
    public Logger log = LogManager.getLogger(getClass().getName());

    @FindBy(css = Variables.SELECT_ROOM)
    private WebElement selectRoom;

    @FindBy(css = Variables.FIRST_GUEST_GENDER)
    private WebElement selectFirstGender;

    @FindBy(id = Variables.FIRST_GUEST_NAME)
    private WebElement setFirstGuestName;

    @FindBy(id = Variables.FIRST_GUEST_SURNAME)
    private WebElement setFirstGuestSurname;

    @FindBy(id = Variables.FIRST_GUEST_BIRTHDAY)
    private WebElement setFirstGuestBirthday;

    @FindBy(id = Variables.FIRST_GUEST_EMAIL)
    private WebElement setFirstGuestEmail;

    @FindBy(id = Variables.FIRST_GUEST_PHONE)
    private WebElement setFirstGuestPhone;

    @FindBy(id = Variables.FIRST_GUEST_CITIZEN_NO)
    private WebElement setFirstGuestCitizenNo;

    @FindBy(css = Variables.SECOND_GUEST_GENDER)
    private WebElement selectSecondGender;

    @FindBy(id = Variables.SECOND_GUEST_NAME)
    private WebElement setSecondGuestName;

    @FindBy(id = Variables.SECOND_GUEST_SURNAME)
    private WebElement setSecondGuestSurname;

    @FindBy(id = Variables.SECOND_GUEST_BIRTHDAY)
    private WebElement setSecondGuestBirthday;

    @FindBy(id = Variables.SECOND_GUEST_CITIZEN_NO)
    private WebElement setSecondGuestCitizenNo;

    @FindBy(id = Variables.PROCEED_TO_PAY)
    private WebElement proceedToPay;

    @FindBy(xpath = Variables.PAY_FOR_CREDIT_CARD)
    private  WebElement payForCreditCard;

    @FindBy(id = Variables.CARD_OWNER)
    private WebElement cardOwner;

    @FindBy(id =Variables.CARD_NUMBER_AREA)
    private WebElement cardNumberArea;

    @FindBy(css = Variables.CARD_CVV_AREA)
    private WebElement cardCvvArea;

    @FindBy(id = Variables.COMPLETE_RESERVATION_BUTTON)
    private WebElement completeReservation;

    @FindBy(css = Variables.SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(css = Variables.ACCOMMODATION_START)
    private WebElement accommodationStart;

    @FindBy(css = Variables.ACCOMMODATION_FINISH)
    private WebElement accommodationFinish;

    @FindBy(id = Variables.DATEPICKER)
    private WebElement datepicker;

    @FindBy(css = Variables.SEARCH_ERROR_ELEMENT)
    private WebElement searchError;

    @FindBy(id = Variables.SEARCH_FORM)
    private WebElement searchForm;

    @FindBy(css = Variables.FIRST_REGION)
    private WebElement selectFirstRegion;

    @FindBy(css = Variables.FIRST_HOTEL)
    private WebElement selectFirstHotel;

    public HotelReservation() {
        driver = Driver.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    public void searchHotel(){
        clickFunction(datepicker);
        clickFunction(accommodationStart);
        clickFunction(accommodationFinish);
        clickFunction(searchButton);
        waitSeconds(3);
        Assert.assertEquals(Variables.SEARCH_ERROR_MESSAGE, searchError.getText());
        log.error("Şehir seçimi yapılmadı.");
        sendKeysFunction(searchForm,Variables.CITY);
        waitSeconds(2);
        clickFunction(selectFirstRegion);
        clickFunction(searchButton);
    }

    public void selectHotel(){
        waitSeconds(2);
        clickFunction(selectFirstHotel);
    }

    public void selectRoom() {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        scrollDown("500");
        waitSeconds(2);
        clickFunction(selectRoom);
    }

    public void setPersonalInformation(){
        scrollDown("300");
        clickFunction(selectFirstGender);
        sendKeysFunction(setFirstGuestName, PersonalData.FIRST_PERSON_NAME);
        sendKeysFunction(setFirstGuestSurname, PersonalData.FIRST_PERSON_SURNAME);
        sendKeysFunction(setFirstGuestBirthday, PersonalData.FIRST_PERSON_BIRTHDAY);
        sendKeysFunction(setFirstGuestEmail, PersonalData.FIRST_PERSON_EMAIL);
        sendKeysFunction(setFirstGuestPhone, PersonalData.FIRST_PERSON_PHONE);
        sendKeysFunction(setFirstGuestCitizenNo, PersonalData.FIRST_PERSON_CITIZEN_NO);
        sendKeysFunction(setSecondGuestName, PersonalData.SECOND_PERSON_NAME);
        sendKeysFunction(setSecondGuestSurname, PersonalData.SECOND_PERSON_SURNAME);
        sendKeysFunction(setSecondGuestBirthday, PersonalData.SECOND_PERSON_BIRTHDAY);
        sendKeysFunction(setSecondGuestCitizenNo, PersonalData.SECOND_PERSON_CITIZEN_NO);
    }

    public void proceedtoPay(){
        waitSeconds(2);
        clickFunction(proceedToPay);
        log.error("Cinsiyet Seçimini Yapınız");
        clickFunction(selectSecondGender);
        log.info("Konuk Bilgileri Dolduruldu");
        clickFunction(proceedToPay);
    }

    public void setPaymentInfo() {
        waitSeconds(5);
        log.info("Ödeme Sayfası Açıldı");
        scrollDown("400");
        clickFunction(payForCreditCard);
        sendKeysFunction(cardOwner,PersonalData.CARD_OWNER);
        sendKeysFunction(cardNumberArea,PersonalData.CARD_NUMBER);
        sendKeysFunction(cardCvvArea,PersonalData.CARD_CVV);
        Select selectMonth = new Select(driver.findElement(By.name(Variables.CARD_MONTH_AREA)));
        selectMonth.selectByIndex(PersonalData.CARD_MONTH);
        Select selectYear = new Select(driver.findElement(By.name(Variables.CARD_YEAR_AREA)));
        selectYear.selectByValue(PersonalData.CARD_YEAR);
        scrollDown("1000");
        clickByJs(Variables.SERVICE_AGREEMENT);
        clickByJs(Variables.KVKK_APPROVAL);
    }
    public void completeReservation(){
        waitSeconds(2);
        clickFunction(completeReservation);
    }
}