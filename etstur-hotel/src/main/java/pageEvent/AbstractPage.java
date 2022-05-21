package pageEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class AbstractPage {
    private WebDriver driver =Driver.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 100);

    public void clickFunction(WebElement clickElement){
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();
    }

    public void sendKeysFunction(WebElement sendKeysElement, String value){
        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(value);
    }
    public void waitSeconds(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void scrollDown(String scrollValue){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+scrollValue+")", "");
    }

    public void clickByJs(String element){
        WebElement webElement = driver.findElement(By.xpath(element));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", webElement);
    }

}

