package pages.Luma;

import engine.ActionsBot;
import engine.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Jackets extends Pages {
    private final By brownJacket = By.xpath("(//li[contains(@class,'product-item')])[4]");
    private final By large = By.id("option-label-size-143-item-169");
    private final By color = By.id("option-label-color-93-item-53");
    private final By addButton = By.id("product-addtocart-button");
    private final By linkCart = By.xpath("(//a[@href='https://magento.softwaretestingboard.com/checkout/cart/'])[3]");
    public Jackets(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    @Step("adding the brown jacket to the cart")
    public Cart addBrownJacket(){
        bot.click(brownJacket);
        bot.click(large);
        bot.click(color);
        bot.click(addButton);
        //bot.click(cart);
        bot.click(linkCart);
        return new Cart(driver,bot);
    }
}
