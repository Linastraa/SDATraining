package pages.Lambdatest;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AfterRegisterationPage extends Pages {
    private final By successMessage = By.xpath("//h1[@class='page-title my-3'][contains(text(),' Your Account Has Been Created!')]");
    public AfterRegisterationPage(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }
    @Step("Getting the successful message from the website and compare it with the expected message")
    public String getMessage(){
        return bot.getText(successMessage);
    }
}
