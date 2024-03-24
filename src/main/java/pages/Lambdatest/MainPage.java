package pages.Lambdatest;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Pages {
    private final String url = "https://ecommerce-playground.lambdatest.io/";
    private final By myAccountLink = By.xpath("(//span[@class='title'][contains(text(),'My account')])[2]");
    public MainPage(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }
    @Step("Navigating to the main page of the LambdaTest website.")
    public MainPage GoTo(){
        bot.navigate(url);
        return this;
    }

    @Step("Clicking on My Account link then navigate to the account page.")
    public MyAccountPage clickOnMyAccount(){
        bot.click(myAccountLink);
        return new MyAccountPage(driver,bot);
    }
}
