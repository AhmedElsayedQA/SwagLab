package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
   private WebDriver driver;
   private By cartPageHeader=By.className("header_secondary_container");
   private By checkoutButton=By.id("checkout");
   private By pageHeader=By.className("header_secondary_container");
   private By addedItem=By.className("inventory_item_name");
    public CartPage(WebDriver driver){
        this.driver=driver;
    }
    public String getCartPageHeader(){
      return   driver.findElement(cartPageHeader).getText();
    }

    //Click the checkout button and navigate to the CheckoutInfoPage.
    public CheckoutInfoPage clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
        return new CheckoutInfoPage(driver);
    }
    public boolean isItemAdded(){
        return driver.findElement(addedItem).isDisplayed();
    }

    }
