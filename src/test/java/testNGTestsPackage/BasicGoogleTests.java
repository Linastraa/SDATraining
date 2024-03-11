package testNGTestsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class BasicGoogleTests extends Tests{

    @Test
    public void quickGoogleSearch(){
        bot.navigate("https://www.google.com/");
        By searchField = By.id("APjFqb");
        bot.type(searchField,"Selenium!" + Keys.ENTER);
        By resultLabel = By.id("result-stats");
        assert !"".equals(driver.findElement(resultLabel).getText());
    }
}
