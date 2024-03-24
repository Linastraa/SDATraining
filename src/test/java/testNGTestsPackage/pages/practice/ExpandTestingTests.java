package testNGTestsPackage.pages.practice;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.practice.LoginPage;
import testNGTestsPackage.base.Tests;

public class ExpandTestingTests extends Tests {

    @Test
    public void successfulLogin(){
        String userName= (String)testCaseData.get("username");
        String password= (String)testCaseData.get("password");

        String actualText= new LoginPage(driver,bot).goTo().successfulLogin(userName,password).getTheActualText();

        Assert.assertEquals(actualText,"You logged into a secure area!");
    }

    @Test
    public void unSuccessfulLogin(){
        String userName= (String)testCaseData.get("username");
        String wrongName= (String)testCaseData.get("wrongPassword");
        String actualText=new LoginPage(driver,bot).goTo().failedLogin(userName,wrongName).WrongMessage();

        Assert.assertEquals(actualText,"Your password is invalid!");
    }
    @BeforeClass
    public void initializeTestDataReader(){
        testCaseData = (JSONObject) testData.get("expandtestingData");
    }
}
