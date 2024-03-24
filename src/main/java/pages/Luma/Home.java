package pages.Luma;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends Pages {
    private final By message = By.xpath("(//span[text()='Welcome, Sulaiman Alzahrani!'])[1]");
    private final By dropDown = By.id("ui-id-5");
    private final By jackets = By.xpath("(//a[@href='https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html'])[2]");
    public Home(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    @Step("Verifying that the user was registered successfully")
    public String getTheActualText(){
        return bot.getText(message);
    }

    @Step("clicking on jacket menu")
    public Jackets selectDropDown(){
        bot.click(dropDown);
        bot.click(jackets);
        return new Jackets(driver,bot);
    }
}
