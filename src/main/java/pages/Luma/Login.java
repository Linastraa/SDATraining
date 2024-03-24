package pages.Luma;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Pages {
    private final By emailField = By.id("email");
    private final By passwordField = By.id("pass");
    private final By loginButton = By.id("send2");
    public Login(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    @Step("Clicking the Login Button to navigate to the home page")
    public Home loginToHome(String email , String password){
        bot.type(emailField,email);
        bot.type(passwordField,password);
        bot.click(loginButton);
        return new Home(driver,bot);
    }
}
