package testNGTestsPackage.pages;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoPages.login.Login;
import testNGTestsPackage.base.Tests;

public class SauceDemoLoginTests extends Tests {

    @Test(testName = "successfully login", description = "using a correct username and password to perform a successful login")
    public void successfulLoginTest(){
        JSONObject testCaseData = (JSONObject) testData.get("SauceDemoLoginTestData");
        String userName= (String)testCaseData.get("username");
        String password= (String)testCaseData.get("password");

        String actualText = new Login(driver,bot).goTo().successfulLogin(userName,password).readHeader();

        Assert.assertEquals(actualText, "Products");
    }

    @Test(testName = "lockedOut login", description = "using a lockedOut username to perform a lockedOut login")
    public void lockedOutUserTest(){
        JSONObject testCaseData = (JSONObject) testData.get("SauceDemoLoginTestData");
        String userName= (String)testCaseData.get("lockedUsername");
        String password= (String)testCaseData.get("password");

        String actualText = new Login(driver,bot).goTo().lockedLogin(userName,password).getTheErrorMessage();

        Assert.assertEquals(actualText,"Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(testName = "problemUser login", description = "using a problem username to perform a successful login but with problems on the main page")
    public void problemUserTest(){
        JSONObject testCaseData = (JSONObject) testData.get("SauceDemoLoginTestData");
        String userName= (String)testCaseData.get("problemUsername");
        String password= (String)testCaseData.get("password");

        String actualText = new Login(driver,bot).goTo().problemLogin(userName,password).readHeader();

        Assert.assertEquals(actualText, "Products");
    }
}
