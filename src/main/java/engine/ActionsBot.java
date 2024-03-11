package engine;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class ActionsBot {
    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    private final Logger logger;

    public ActionsBot(WebDriver driver, Wait<WebDriver> wait, Logger logger){
        this.driver = driver;
        this.wait = wait;
        this.logger = logger;
    }

    public void navigate(String url){
        logger.info("Navigating to: "+url);
        driver.navigate().to(url);
    }

    public void type(By locator, CharSequence text){
        logger.info("Typing: "+text+", into: "+locator);
        wait.until(f ->{
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
            return true;
        });
    }

    public void click(By locator){
        logger.info("Clicking: "+locator);
        wait.until(f ->{
            driver.findElement(locator).click();
            return true;
        });
    }
}