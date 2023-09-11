package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutReviewPage {
    private WebDriver driver;
    private By pageHeader=By.className("header_secondary_container");
    private By finishButton=By.id("finish");

    public CheckoutReviewPage(WebDriver driver){
        this.driver=driver;
    }
    public String getPageHeader(){
       return driver.findElement(pageHeader).getText();
    }

    //Click the checkout finish button and navigate to the Checkout Complete page

    public CheckoutCompletePage clickFinishButton(){
        driver.findElement(finishButton).click();
        return new CheckoutCompletePage(driver);

    }
}
