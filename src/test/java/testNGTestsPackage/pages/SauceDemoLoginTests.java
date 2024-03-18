package testNGTestsPackage.pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.inventory.Inventory;
import pages.login.Login;
import testNGTestsPackage.Tests;

public class SauceDemoLoginTests extends Tests {

    private final By errorMessage = By.xpath("//h3[@data-test='error']");
    @Test(testName = "successfully login", description = "using a correct username and password to perform a successful login")
    public void successfulLoginTest(){
        Login loginPage = new Login(driver,bot);
        loginPage.goTo();
        JSONObject testCaseData = (JSONObject) testData.get("SauceDemoLoginTestData");
        loginPage.login((String) testCaseData.get("username"),(String) testCaseData.get("password"));
        Inventory inventoryPage = new Inventory(driver, bot);
        Assert.assertEquals(inventoryPage.readHeader(), "Products");
    }

    @Test(testName = "lockedOut login", description = "using a lockedOut username to perform a lockedOut login")
    public void lockedOutUserTest(){
        Login loginPage = new Login(driver,bot);
        loginPage.goTo();
        JSONObject testCaseData = (JSONObject) testData.get("SauceDemoLoginTestData");
        loginPage.login((String) testCaseData.get("lockedUsername"),(String) testCaseData.get("password"));
        Assert.assertEquals(driver.findElement(errorMessage).getText(),"Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(testName = "problemUser login", description = "using a problem username to perform a successful login but with problems on the main page")
    public void problemUserTest(){
        Login loginPage = new Login(driver,bot);
        loginPage.goTo();
        JSONObject testCaseData = (JSONObject) testData.get("SauceDemoLoginTestData");
        loginPage.login((String) testCaseData.get("problemUsername"),(String) testCaseData.get("password"));
        Inventory inventoryPage = new Inventory(driver, bot);
        Assert.assertEquals(inventoryPage.readHeader(), "Products");
    }
}
