package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageEvent.HotelReservation;
import utilities.Driver;
import utilities.Variables;
import java.util.concurrent.TimeUnit;

public class HotelReservationStep {
    private WebDriver driver;
    HotelReservation hotelReservation = new HotelReservation();

    @Given("^Anasayfa Açılır$")
    public void goToHomepage() {
        driver = Driver.getWebDriver();
        driver.get(Variables.HOMEPAGE_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @When("^Otel Araması Yapılır$")
    public void searchHotel() {
        hotelReservation.searchHotel();
    }

    @And("^Otel Seçilir$")
    public void selectHotel() {
        hotelReservation.selectHotel();
    }

    @And("^Oda Seçilir$")
    public void selectRoom() {
        hotelReservation.selectRoom();
    }

    @And("^Kişi Bilgileri Doldurulur$")
    public void setPersonalInformation() {
        hotelReservation.setPersonalInformation();
        hotelReservation.proceedtoPay();
    }

    @And("^Ödeme Bilgileri Doldurulur$")
    public void setPaymentInformation() {
        hotelReservation.setPaymentInfo();
    }

    @Then("^Ödeme İçin İlerle Butonuna Tıklanır$")
    public void clickPaymentButton() {
        hotelReservation.completeReservation();
        driver.quit();
    }

}
