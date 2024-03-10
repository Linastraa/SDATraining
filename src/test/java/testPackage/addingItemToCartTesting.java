package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class addingItemToCartTesting extends Tests{

    /*
    navigate to this url https://www.saucedemo.com/v1/inventory.html
add the first item you find to your cart
open your cart*
assert that the item name is correct inside the cart
     */

    @Test
    public void addFirstItemToCart(){
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");

        WebElement firstItem = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        firstItem.click();

        WebElement button = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/button"));
        button.click();
        WebElement cart = driver.findElement(By.id("shopping_cart_container"));
        cart.click();
        String itemInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        System.out.println(itemInCart);
        Assertions.assertEquals("Sauce Labs Backpack",itemInCart);
    }

}
