package junitTestsPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class addingItemToCartTesting extends Tests{

    /*
    navigate to this url https://www.saucedemo.com/v1/inventory.html
add the first item you find to your cart
open your cart*
assert that the item name is correct inside the cart
     */

    @Test
    public void addFirstItemToCart(){
        bot.navigate("https://www.saucedemo.com/v1/inventory.html");

        By firstItem = By.xpath("(//button[contains(@class,btn_inventory)])[3]");
        bot.click(firstItem);

        By cart = By.id("shopping_cart_container");
        bot.click(cart);

        String itemInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        System.out.println(itemInCart);
        Assertions.assertEquals("Sauce Labs Backpack",itemInCart);
    }

}
