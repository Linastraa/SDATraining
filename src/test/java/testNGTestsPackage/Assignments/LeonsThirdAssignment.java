package testNGTestsPackage.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testNGTestsPackage.Tests;

public class LeonsThirdAssignment extends Tests {

    @Test
    public void test(){
        //Go to URL: http://demo.guru99.com/test/drag_drop.html
        bot.navigate("http://demo.guru99.com/test/drag_drop.html");

        //Drag and drop the BANK button to the Account section in DEBIT SIDE
        logger.info("Dragging and dropping the BANK button to the Account section in DEBIT SIDE");
        By bankButton = By.xpath("//li[contains(@class,'block14 ui-draggable')]");
        By bankPlaceHolder = By.id("bank");
        new Actions(driver)
                .dragAndDrop(driver.findElement(bankButton)
                        ,driver.findElement(bankPlaceHolder))
                .perform();

        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        logger.info("Dragging and dropping the SALES button to the Account section in CREDIT SIDE");
        By salesButton = By.xpath("//li[contains(@class,'block15 ui-draggable')]");
        By salesPlaceHolder = By.id("loan");
        new Actions(driver)
                .dragAndDrop(driver.findElement(salesButton)
                        ,driver.findElement(salesPlaceHolder))
                .perform();

        //Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        logger.info("Dragging and dropping the 5000 button to the Amount section in DEBIT SIDE");
        By first5000Button = By.xpath("//li[@data-id='2']");
        By firstAmountPlaceHolder = By.id("amt7");
        new Actions(driver)
                .dragAndDrop(driver.findElement(first5000Button)
                        ,driver.findElement(firstAmountPlaceHolder))
                .perform();

        //Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        logger.info("Dragging and dropping the second 5000 button to the Amount section in CREDIT SIDE");
        By second5000Button = By.xpath("//li[@data-id='2']");
        By secondAmountPlaceHolder = By.id("amt8");
        new Actions(driver)
                .dragAndDrop(driver.findElement(second5000Button)
                        ,driver.findElement(secondAmountPlaceHolder))
                .perform();

        //Verify the visibility of Perfect text.
        logger.info("Verifying the visibility of Perfect text.");
        By text = By.xpath("(//a[contains(@class,'button button-green')])[1]");
        String actual =driver.findElement(text).getText();
        Assert.assertEquals(actual,"Perfect!");
    }
}
