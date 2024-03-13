package testNGTestsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BasicGoogleTests extends Tests{

    @Parameters({ "first-name" })
    @Test
    public void quickGoogleSearch(String searchQuery){
        bot.navigate("https://www.google.com/");
        By searchField = By.id("APjFqb");
        bot.type(searchField,searchQuery+ Keys.ENTER);
        By resultLabel = By.id("result-stats");
        System.out.println(driver.findElement(resultLabel).getText());
        Assert.assertNotEquals(driver.findElement(resultLabel).getText(), "");
    }
}
