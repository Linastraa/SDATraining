package pages.Luma;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class myAccount extends Pages {
    private final By message = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    public myAccount(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    @Step
    public String getTheActualText(){
        //return driver.findElement(actualText).getText();
        return bot.getText(message);
    }

}
