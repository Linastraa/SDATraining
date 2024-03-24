package testNGTestsPackage;

import engine.CustomListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testNGTestsPackage.base.Tests;

import java.util.concurrent.atomic.AtomicReference;

@Listeners(CustomListeners.class)
public class BasicGoogleTests extends Tests {

    @Parameters({ "searchQuery" })
    @Test
    public void quickGoogleSearch(@Optional("Selenium WebDriver") String searchQuery){
        bot.navigate("https://www.google.com/");
        By searchField = By.id("APjFqb");
        bot.type(searchField,searchQuery+ Keys.ENTER);
        By resultLabel = By.id("result-stats");

        AtomicReference<String> actualText = new AtomicReference<>();
        wait.until(f ->{
            actualText.set(driver.findElement(resultLabel).getText());
        return true; });
        Assert.assertNotEquals(actualText, "");
        System.out.println(driver.findElement(resultLabel).getText());
    }

    @Test(testName = "Check Google Logo Exists", description = "Given I am on the Google homepage, Then the Google logo should be displayed")
    public void assertGoogleLogoExists(){
        bot.navigate("https://www.google.com/");
        By googleLogoImage = By.id("hplogo");
        Assert.assertTrue(driver.findElement(googleLogoImage).isDisplayed());
    }
}
