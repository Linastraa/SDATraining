package testNGTestsPackage.pages;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Luma.Main;
import testNGTestsPackage.base.Tests;

public class LumaTests extends Tests {
    @Test
    public void registration(){
        JSONObject testCaseData = (JSONObject) testData.get("LumaData");
        String fName= (String)testCaseData.get("firstName");
        String lName= (String)testCaseData.get("lastName");
        String mail= (String)testCaseData.get("email");
        String pass= (String)testCaseData.get("password");
        String cpass= (String)testCaseData.get("cpassword");
        String actualText = new Main(driver,bot).goTo().register().createAnAccount(fName,lName,mail,pass,cpass).getTheActualText();

        Assert.assertEquals(actualText,"Thank you for registering with Main Website Store.");
    }

    @Test//(dependsOnMethods ="registration")
    public void logging(){
        JSONObject testCaseData = (JSONObject) testData.get("LumaData");
        String mail= (String)testCaseData.get("email");
        String pass= (String)testCaseData.get("password");

        var home = new Main(driver,bot).goTo().login().loginToHome(mail,pass);
        String actualText = home.getTheActualText();

        var cart = home.selectDropDown().addBrownJacket();
        String actualName = cart.getJacketName();
        String actualSize = cart.getSize();
        String actualColor = cart.getColor();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualText,"Welcome, Sulaiman Alzahrani!");
        softAssert.assertEquals(actualName,"Typhon Performance Fleece-lined Jacket");
        softAssert.assertEquals(actualSize,"L");
        softAssert.assertEquals(actualColor,"Green");
        softAssert.assertAll();
    }
}
