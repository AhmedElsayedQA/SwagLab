package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.*;

public class HomePage {
    private WebDriver driver;
    double minPrice;
    int minPriceIndex;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By items = By.className("inventory_item_name");
    private By itemsPrices = By.className("inventory_item_price");
    private double[] pricesValue;

    public int getLowestPriceIndex() {
        List<WebElement> prices = driver.findElements(itemsPrices);

        pricesValue = new double[prices.size()];

        //Get double values of strings after deleting  "$" sign
        for (int i = 0; i <= prices.size() - 1; i++) {
            String priceText = prices.get(i).getText().substring(1);
            pricesValue[i] = Double.parseDouble(priceText);
            System.out.println(pricesValue[i] );
        }


        //find the index of the item with minimum price
        minPrice = pricesValue[0];
        minPriceIndex=0;
        for (int j = 0; j <= pricesValue.length - 1; j++) {
            if (pricesValue[j] < minPrice) {
                minPrice = pricesValue[j];
                minPriceIndex = j;
            }
        }
        System.out.println("The "+ (minPriceIndex+1)+"item is the lowest price item");
        System.out.println("Price = " +minPrice);

        return minPriceIndex;
    }

    //Click the lowest item link and navigate to the item page.

    public ItemPage clickLowestPriceItem(int itemIndex){
        driver.findElements(items).get(itemIndex).click();
        return new ItemPage(driver);

    }

}
