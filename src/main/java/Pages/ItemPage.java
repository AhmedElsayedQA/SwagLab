package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {
    private By backButton= By.id("back-to-products");
    private By addToCartButton=By.id("add-to-cart-sauce-labs-onesie");
    private By shoopingCartButton=By.className("shopping_cart_link");
    private WebDriver driver;
    public ItemPage(WebDriver driver){
        this.driver=driver;
    }
    public boolean findBackButton(){
       return driver.findElement(backButton).isDisplayed();

    }
    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();

    }
    //Click the shopping cart  icon and navigate to the shopping cart page

    public CartPage clickShoppingCartButton(){
        driver.findElement(shoopingCartButton).click();
        return new CartPage(driver);
    }
}
