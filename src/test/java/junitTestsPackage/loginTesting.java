package junitTestsPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class loginTesting extends Tests{

    String inventoryPage ="https://www.saucedemo.com/v1/inventory.html";
    String mainPage="https://www.saucedemo.com/v1/index.html";
    String password="secret_sauce";

/**
 * breakout task:
 * <br/> - navigate to this url <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
 * <br/> - do a successful login
 * <br/> - assert that the login is successful
 */

/**
 * breakout task:
 * <br/> - navigate to this url <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
 * <br/> - do a locked_out_user login
 * <br/> - assert that the login was not successful (do a negative test, and a positive test)
 */

    @Test
    public void firstLogin(){
        loginInform("standard_user",password);
        String pageURL= driver.getCurrentUrl();
        Assertions.assertEquals(inventoryPage,pageURL);

    }

    @Test
    public void secondLoginWrongMessage(){
        loginInform("locked_out_user",password);

        String incorrect = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", incorrect);

    }

    @Test
    public void secondLoginFailTest(){
        loginInform("locked_out_user",password);
        String pageURL= driver.getCurrentUrl();
        Assertions.assertNotEquals(inventoryPage,pageURL);

    }

    private void loginInform(String username, String password){
        bot.navigate("https://www.saucedemo.com/v1/index.html");

        By userField = By.id("user-name");
        bot.type(userField,username);

        By passField = By.id("password");
        bot.type(passField,password);

        By loginButton = By.id("login-button");
        bot.click(loginButton);
    }
}
