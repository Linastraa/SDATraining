package pages.Lambdatest;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends Pages {
    private final By registerLink = By.xpath("//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/register'][@class='list-group-item']");
    public MyAccountPage(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }
    @Step("Clicking on Register button then navigate to the registration page")
    public RegisterPage clickOnRegister(){
        bot.click(registerLink);
        return new RegisterPage(driver,bot);
    }
}
