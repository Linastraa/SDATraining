package junitTestsPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class googleTesting extends Tests {


    @Test
    public void radioButtonVerification3() {
        bot.navigate("https://google.com/");
        By searchBox = By.id("APjFqb");
        bot.type(searchBox,"Selenium" + Keys.ENTER);
        //driver.findElement(searchBox).sendKeys("Selenium" + Keys.ENTER);
        By expectedResult = By.xpath("//div[@id='result-stats']");

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> driver.findElement(expectedResult).isDisplayed());

        String result = driver.findElement(expectedResult).getText();
        System.out.println(result);
        Assertions.assertNotEquals("", result);
    }
}



