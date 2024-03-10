package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

/**
 * Navigate to <a href="https://www.w3schools.com/html/html_tables.asp">w3schools tables</a>
 * check that the Contact for "Alfreds Futterkiste" company is "Maria Anders"
 */


public class w3schoolsTesting extends Tests{


    @Test
    public void loginInform(){
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");

        By name = RelativeLocator.with(By.xpath("//table[@id='customers']//tr[td[text()='Alfreds Futterkiste']]/td[position()=2]"));
        var actualName = driver.findElement(name).getText();
        Assertions.assertEquals("Maria Anders",actualName);

    }

}


