package testNGTestsPackage.Assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testNGTestsPackage.base.Tests;

public class Task4Tests extends Tests {

    @Test(dataProvider = "searchItems")
    public void test(String item){
        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");
        By emailInput = By.id("input-email");
        By passwordInput = By.id("input-password");
        By loginButton = By.xpath("//input[@value='Login']");

        bot.type(emailInput,"clarusway@gmail.com");
        bot.type(passwordInput,"123456789");
        bot.click(loginButton);

        By searchInput = By.name("search");
        bot.type(searchInput,item+Keys.ENTER);

        int searchResultsCount = driver.findElements(By.xpath("//div[contains(@class,'product-layout')]")).size();
        System.out.println("Search results for " + item + ": " + searchResultsCount);
    }

    @DataProvider(name = "searchItems")
    public Object[][] searchItemsProvider() {
        return new Object[][]{{"Mac"}, {"iPad"}, {"Samsung"}};
    }
}

