package testNGTestsPackage.pages;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Lambdatest.MainPage;
import testNGTestsPackage.base.Tests;

public class LambdaTests extends Tests {
    @Test
    public void test(){
        JSONObject testCaseData = (JSONObject) testData.get("LambdaTest");
        String fName= (String)testCaseData.get("firstName");
        String lName= (String)testCaseData.get("lastName");
        String mail= (String)testCaseData.get("email");
        String telephone= (String)testCaseData.get("telephone");
        String pass= (String)testCaseData.get("password");
        String cpass= (String)testCaseData.get("cpassword");
        String actualMessage = new MainPage(driver,bot).GoTo().clickOnMyAccount().clickOnRegister().register(fName,lName,mail,telephone,pass,cpass).getMessage();
        Assert.assertEquals(actualMessage,"Your Account Has Been Created!");
    }
}
