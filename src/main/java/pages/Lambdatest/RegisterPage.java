package pages.Lambdatest;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Pages {
    private final By firstNameField = By.id("input-firstname");
    private final By lastNameField = By.id("input-lastname");
    private final By emailField = By.id("input-email");
    private final By telephoneField = By.id("input-telephone");
    private final By passwordField = By.id("input-password");
    private final By confirmPasswordField = By.id("input-confirm");
    private final By yesRadioButton = By.id("input-newsletter-yes");
    private final By checkBox = By.id("input-agree");
    private final By continueButton = By.xpath("//input[@value='Continue']");
    public RegisterPage(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }
    @Step("filling the form to register a new user.")
    public AfterRegisterationPage register(String fname,String lname,String email,String telephone,String password,String cpassword){
        bot.type(firstNameField,fname);
        bot.type(lastNameField,lname);
        bot.type(emailField,email);
        bot.type(telephoneField,telephone);
        bot.type(passwordField,password);
        bot.type(confirmPasswordField,cpassword);
        bot.click(yesRadioButton);
        bot.click(checkBox);
        bot.click(continueButton);
        return new AfterRegisterationPage(driver,bot);
    }
}
