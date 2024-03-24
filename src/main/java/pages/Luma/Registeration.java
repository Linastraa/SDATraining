package pages.Luma;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registeration extends Pages {
    private final By firstNameField = By.id("firstname");
    private final By lastNameField = By.id("lastname");
    private final By emailField = By.id("email_address");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("password-confirmation");
    private final By createAnAccountButton = By.xpath("//button[contains(@class,'action submit primary')]");
    public Registeration(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    @Step("Clicking the Create Account Button to create an account then navigate to the home page")
    public myAccount createAnAccount(String fname , String lname , String email , String password , String cpassword){
        bot.type(firstNameField,fname);
        bot.type(lastNameField,lname);
        bot.type(emailField,email);
        bot.type(passwordField,password);
        bot.type(confirmPasswordField,cpassword);
        bot.click(createAnAccountButton);
        return new myAccount(driver,bot);
    }
}
