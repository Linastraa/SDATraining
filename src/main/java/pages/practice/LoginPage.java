package pages.practice;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Pages {

    private final String url = "https://practice.expandtesting.com/login";
    private final By usernameTextArea = By.id("username");
    private final By passwordTextArea = By.id("password");
    private final By loginButton = By.xpath("//button[text()='Login']");
    private final By wrongMessage = By.id("flash-message");

    public LoginPage(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }


    @Step("Navigate to the practice.expandtesting login page")
    public LoginPage goTo(){
        bot.navigate(url);
        return this;
    }

    private void login(String username, String password){
        bot.type(usernameTextArea, username);
        bot.type(passwordTextArea, password);
        bot.click(loginButton);
    }

    @Step("Successful Login to practice.expandtesting")
    public mainPage successfulLogin(String username, String password){
        login(username, password);
        return new mainPage(driver,bot);
    }

    @Step("UnSuccessful Login to practice.expandtesting")
    public LoginPage failedLogin(String username, String password){
        login(username, password);
        return this;
    }

    @Step
    public String WrongMessage(){
        return bot.getText(wrongMessage);
    }
}
