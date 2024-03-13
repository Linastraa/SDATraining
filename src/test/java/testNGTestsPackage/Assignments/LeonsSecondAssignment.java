package testNGTestsPackage.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testNGTestsPackage.Tests;

import java.util.Iterator;
import java.util.Set;

public class LeonsSecondAssignment extends Tests {

    @Test
    public void test(){
        //Go to URL: https://the-internet.herokuapp.com/windows
       bot.navigate("https://the-internet.herokuapp.com/windows");
        SoftAssert softAssert = new SoftAssert();

        //Verify the text: “Opening a new window”
        logger.info("Verifying the text: “Opening a new window”");
        By actualText = By.tagName("h3");
        softAssert.assertEquals(driver.findElement(actualText).getText(),"Opening a new window");

        //Verify the title of the page is “The Internet”
        logger.info("Verifying the title of the page is “The Internet”");
        String title = driver.getTitle();
        softAssert.assertEquals(title,"The Internet");

        //Click on the “Click Here” button
        logger.info("Clicking on the “Click Here” button");
        By button = By.xpath("//a[@href='/windows/new']");
        bot.click(button);
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String handle : handles) {
            if (!handle .equals(currentHandle))
            {
                driver.switchTo().window(handle);
            }
        }

        //Verify the new window title is “New Window”
        logger.info("Verifying the new window title is “New Window”");
        String titlee = driver.getTitle();
        softAssert.assertEquals(titlee,"New Window");

        System.out.println("*********************************************************");

        //Go back to the previous window and then verify the title: “The Internet”
        logger.info("Going back to the previous window and then verify the title: “The Internet”");
        for (String handle : handles) {
            if (handle .equals(currentHandle))
            {
                driver.switchTo().window(handle);
            }
        }
        String titleee = driver.getTitle();
        softAssert.assertEquals(titleee,"The Internet");

        softAssert.assertAll();
    }
}
