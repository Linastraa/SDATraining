package pages.practice;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mainPage extends Pages {

    private final By actualText = By.xpath("//b[contains(text(),'You logged into a secure area!')]");

    public mainPage(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    @Step
    public String getTheActualText(){
        //return driver.findElement(actualText).getText();
        return bot.getText(actualText);
    }
}
