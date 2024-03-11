package junitTestsPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class loginAndCartTesting extends Tests{



    String inventoryPage ="https://www.saucedemo.com/v1/inventory.html";
    String mainPage="https://www.saucedemo.com/v1/index.html";
    String cartPage="https://www.saucedemo.com/v1/cart.html";
    String password="secret_sauce";
    String user="standard_user";

    /**
     * Navigate to <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
     * login as standard_user
     * assert that there are 6 items on the products list page
     * add the first and last items to the cart
     * navigate to the cart and check that both items are listed
     */


    public void Login(){

        loginInform(user,password);
    }


    private void loginInform(String username, String password){
        bot.navigate(mainPage);

        By userField = By.id("user-name");
        bot.type(userField,username);

        By passField = By.id("password");
        bot.type(passField,password);

        By loginButton = By.id("login-button");
        bot.click(loginButton);
    }

    @Test
    public void sixItemsAssertions(){
        Login();
        int size =driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
        Assertions.assertEquals(6,size);

    }

    @Test
    public void addingFirstAndLastItemToCart(){
        Login();

        By firstItemButton = By.xpath("(//button[contains(@class,'btn_primary')])[1]");
        bot.click(firstItemButton);

        By lastItemButton = By.xpath("(//button[contains(@class,'btn_primary')])[5]");
        bot.click(lastItemButton);

        bot.navigate(cartPage);
        String firstName=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
        String secondName=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[2]")).getText();
        String finalName=firstName+" "+secondName;
        Assertions.assertEquals("Sauce Labs Backpack Test.allTheThings() T-Shirt (Red)",finalName);


    }

}

