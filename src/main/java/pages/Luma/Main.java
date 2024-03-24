package pages.Luma;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main extends Pages {
    private final String url = "https://magento.softwaretestingboard.com/";
    private final By CreateAccountUrl = By.xpath("(//a[contains(@href,'create')])[1]");
    private final By loginUrl = By.xpath("(//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/'])[1]");
    public Main(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    @Step("Navigate to the main page")
    public Main goTo(){
        bot.navigate(url);
        return this;
    }

    @Step("Clicking the Create Account Button to navigate to the Create Account Page")
    public Registeration register(){
        bot.click(CreateAccountUrl);
        return new Registeration(driver,bot);
    }

    @Step("Clicking the Create Account Button to navigate to the Create Account Page")
    public Login login(){
        bot.click(loginUrl);
        return new Login(driver,bot);
    }
}
