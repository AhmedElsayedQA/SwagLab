package Tests;

import Base.BaseTests;
import Pages.*;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckoutFlowTest extends BaseTests {

    @Test()

    public void verifyLowestPriceItemCheckoutFlow(){
        //1-Login with valid credentials
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("secret_sauce");
       HomePage homePage =loginPage.clickLoginButton();

       //Verifying success of login
        assertTrue(driver.getCurrentUrl()
                .contains("https://www.saucedemo.com/inventory.html"),
                "Login Failed");

       //2-Select lowest price item &Verifying item selection
        int index=homePage.getLowestPriceIndex();
        ItemPage itemPage= homePage.clickLowestPriceItem(index);
        assertTrue(itemPage.findBackButton(),"Navigation to Item page Failed");

       //3-adding the item to the cart
        itemPage.clickAddToCartButton();

        //4-navigating to shopping cart &verifying navigation to shopping Cart Page
        CartPage cartPage=itemPage.clickShoppingCartButton();
        assertTrue(cartPage.getCartPageHeader().
                contains("Your Cart"),"Navigation To Cart Page Failed");

        assertTrue(cartPage.isItemAdded(),"Item is not added to Cart");

        //5-Checking-out &verifying navigation to Check out info Page
        CheckoutInfoPage checkoutInfoPage=cartPage.clickCheckoutButton();
        assertTrue(checkoutInfoPage.getPageHeader().
                contains("Checkout: Your Information"),"proceeding to Checkout info page failed");

        //6-adding required information to Check out
        checkoutInfoPage.setFirstNameField("Ahmed");
        checkoutInfoPage.setLastNameField("Elsayed");
        checkoutInfoPage.setPostalCodeField("44111");

        CheckoutReviewPage checkoutReviewPage=checkoutInfoPage.clickContinueButton();
        //verifying navigation to Check out info Page
        assertTrue(checkoutReviewPage.getPageHeader()
                .contains("Checkout: Overview"),"proceeding to Checkout overview page failed");

        //7-Finishing Checkout Process&verifying order completion
        CheckoutCompletePage checkoutCompletePage=checkoutReviewPage.clickFinishButton();
        assertTrue(checkoutCompletePage.getSuccessMessage()
                .contains("Thank you for your order!"),"Failed to finish order check out ");

    }
}
