package pages.Luma;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends Pages {
    private final By jacket = By.xpath("(//a[contains(text(),'Jacket')])[2]");
    private final By size = By.xpath("//dd[contains(text(),'L')]");
    private final By color = By.xpath("//dd[contains(text(),'Green')]");
    public Cart(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    @Step("Getting the jacket name")
    public String getJacketName(){
        return bot.getText(jacket);
    }

    @Step("Getting the jacket size")
    public String getSize(){
        return bot.getText(size);
    }

    @Step("Getting the jacket color")
    public String getColor(){
        return bot.getText(color);
    }
}
