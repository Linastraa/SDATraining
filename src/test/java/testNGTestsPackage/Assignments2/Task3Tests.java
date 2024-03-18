package testNGTestsPackage.Assignments2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testNGTestsPackage.Tests;

public class Task3Tests extends Tests {

    @Test
    public void test(){
        bot.navigate("https://practicetestautomation.com/practice-test-login/");

        By userNameField =  By.id("username");
        By passwordField =  By.id("password");
        By loginButton = By.id("submit");

        bot.type(userNameField,"student");
        bot.type(passwordField,"incorrectPassword");
        bot.click(loginButton);

        By errorMessage = By.id("error");
        wait.until(f->driver.findElement(errorMessage).isDisplayed());

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(driver.findElement(errorMessage).isDisplayed());
        softAssert.assertEquals(driver.findElement(errorMessage).getText(),"Your password is invalid!");

        softAssert.assertAll();
    }
}
