package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class draggingAndScrollingTesting extends Tests{


    @Test
    public void scrollTest(){
        driver.navigate().to("https://rangeslider.js.org/");

        wait.until(f ->{
            new Actions(driver)
                    .dragAndDropBy(driver.findElement(By.className("rangeslider__handle"))
                    ,10,0).perform();
            return driver.findElement(By.id("js-output")).getText().equals("700");
        });
        String text = driver.findElement(By.id("js-output")).getText();
        Assertions.assertEquals("700",text);
    }

    @Test
    public void dragTest(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/droppableItems.html");
        By dragLocator = By.id("draggable");
        By dropLocator = By.id("droppable");
        new Actions(driver)
                .dragAndDrop(driver.findElement(dragLocator)
                ,driver.findElement(dropLocator))
                .perform();
        String dropText = driver.findElement(dropLocator).getText();
        Assertions.assertEquals("Dropped!",dropText);
    }

    @Test
    public void windowTest(){
        driver.navigate().to("https://www.selenium.dev/");

        By browserStackImage = By.xpath("//img[@alt='BrowserStack']");
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        new Actions(driver)
                .scrollToElement(driver.findElement(browserStackImage))
                .perform();
        driver.findElement(browserStackImage).click();



    }
}
