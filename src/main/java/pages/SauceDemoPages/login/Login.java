package pages.SauceDemoPages.login;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SauceDemoPages.inventory.Inventory;

public class Login extends Pages {

    private final String url = "https://www.saucedemo.com/v1/index.html";
    private final By usernameTextArea = By.id("user-name");
    private final By passwordTextArea = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");

    public Login(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }


    @Step("Navigate to the SauceDemo login page")
    public Login goTo(){
        bot.navigate(url);
        return this;
    }

    private void login(String username, String password){
        bot.type(usernameTextArea, username);
        bot.type(passwordTextArea, password);
        bot.click(loginButton);
    }

    @Step("Successful Login to SauceDemo")
    public Inventory successfulLogin(String username, String password){
        login(username, password);
        return new Inventory(driver,bot);
    }

    @Step("LockedOut Login to SauceDemo")
    public Inventory problemLogin(String username, String password){
        login(username, password);
        return new Inventory(driver,bot);
    }

    @Step("Unsuccessful Login to SauceDemo")
    public Login lockedLogin(String username, String password){
        login(username, password);
        return this;
    }

    @Step
    public String getTheErrorMessage(){
        return bot.getText(errorMessage);
    }
}
