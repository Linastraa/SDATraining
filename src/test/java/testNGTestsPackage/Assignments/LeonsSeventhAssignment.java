package testNGTestsPackage.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import testNGTestsPackage.Tests;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class LeonsSeventhAssignment extends Tests {


    @Test
    public void test() throws IOException {
        // Go to amazon.com
        bot.navigate("https://www.amazon.sa/");

        // Take Full Page Screenshot.
        logger.info("Taking a screenshot of the full page");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("FullPageScreenshot"+System.currentTimeMillis()+".png"));

        // Take any specific WebElement ScreenShot
        logger.info("Taking a screenshot of a specific element");
        if(driver.getTitle().equals("Amazon.sa")){
            By element = By.xpath("//div[@class='a-row a-spacing-double-large']");
            File elementScreenShot = driver.findElement(element).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(elementScreenShot,new File("ElementScreenShot"+System.currentTimeMillis()+".png"));
    }   else{
            By element = By.id("fPD8esuock7FNCatf6QIaA");
            File elementScreenShot = driver.findElement(element).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(elementScreenShot,new File("ElementScreenShot"+System.currentTimeMillis()+".png"));
        }
    }
}
