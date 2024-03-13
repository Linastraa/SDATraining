package testNGTestsPackage.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import testNGTestsPackage.Tests;

public class LeonsFourthAssignment extends Tests {

    @Test
    public void test(){
        // go to https://www.google.com/
        bot.navigate("https://www.google.com/");

        // search for "Scroll Methods" by using an Actions object
        By searchField = By.id("APjFqb");
        bot.type(searchField, Keys.SHIFT+"s"+Keys.SHIFT+"croll"+Keys.SPACE+Keys.SHIFT+"m"+Keys.SHIFT+"ethods"+Keys.ENTER);
        By text = By.id("result-stats");
        System.out.println(driver.findElement(text).getText());
        System.out.println(driver.findElement(searchField).getText());
    }
}
