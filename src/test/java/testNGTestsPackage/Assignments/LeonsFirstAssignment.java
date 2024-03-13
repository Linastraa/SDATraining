package testNGTestsPackage.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testNGTestsPackage.Tests;


public class LeonsFirstAssignment extends Tests {

    @Test
    public void test(){
        //Go to URL: https://api.jquery.com/dblclick/
        bot.navigate("https://api.jquery.com/dblclick/");

        By frame = By.tagName("iframe");
        driver.switchTo().frame(driver.findElement(frame));
        By blueBox = By.tagName("div");
        logger.info("the color before clicking: "+driver.findElement(blueBox).getCssValue("background-color"));

        //Double click on the blue square at the bottom of the page and then write the changed color.
        new Actions(driver)
                .doubleClick(driver.findElement(blueBox))
                .perform();
        logger.info("the color after clicking: "+driver.findElement(blueBox).getCssValue("background-color"));

        //Go top of the page and sendKeys "Thanks to JavascriptExecutor"
        driver.switchTo().defaultContent();
        By inputField = By.name("s");
        bot.type(inputField,"Thanks to JavascriptExecuter" + Keys.ENTER);

        //Go to the bottom of the page and click the book, name"jQuery in Action"
        By bookLocator = By.xpath("//img[contains(@alt,'jQuery in Action')]");
        bot.click(bookLocator);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.manning.com/books/jquery-in-action-third-edition");
    }
}
