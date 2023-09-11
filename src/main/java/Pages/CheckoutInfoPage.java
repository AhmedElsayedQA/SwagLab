package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage {
    private WebDriver driver;
    private By firstNameField= By.id("first-name");
    private By lastNameField= By.id("last-name");
    private By postalCodeField= By.id("postal-code");
    private By pageHeader=By.className("header_secondary_container");

    private By continueButton=By.id("continue");

    public CheckoutInfoPage(WebDriver driver){
        this.driver=driver;
    }

    public String getPageHeader(){
        return driver.findElement(pageHeader).getText();
    }
    public void setFirstNameField(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setLastNameField(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void setPostalCodeField(String postalCode){
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    //Click the checkout continue button and navigate to the Checkout Review page

    public CheckoutReviewPage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new CheckoutReviewPage(driver);
    }
}
