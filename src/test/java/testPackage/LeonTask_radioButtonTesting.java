package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class LeonTask_radioButtonTesting extends Tests{



    /** Task 1:
    - Go to URL: https://demoqa.com/radio-button
    - Verify whether all 3 options given to the question can be selected.
    - When each option is selected, print the following texts on the console.**/


    @Test
    public void radioButtonVerification1() {

        driver.navigate().to("https://demoqa.com/radio-button");

        By radio1 = By.xpath("//label[@class='custom-control-label' and @for='yesRadio']");
        driver.findElement(radio1).click();

        //WebElement yesButton= driver.findElement(By.xpath("//input[@id='yesRadio']"));
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("arguments[0].click()", yesButton);
        boolean test1=driver.findElement(radio1).isEnabled();
        System.out.print("'"+test1+"'");
        String text = driver.findElement(By.xpath("//p[@class='mt-3']")).getText();
        System.out.println(" "+text);

        Assertions.assertEquals("You have selected Yes",text);
    }

    @Test
    public void radioButtonVerification2() {
        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement impressiveButton = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click()", impressiveButton);
        boolean test2 = impressiveButton.isEnabled();
        System.out.print("'" + test2 + "'");
        String text1 = driver.findElement(By.xpath("//p[@class='mt-3']")).getText();
        System.out.println(" " + text1);

        Assertions.assertEquals("You have selected Impressive", text1);
    }

    @Test
    public void radioButtonVerification3() {
        driver.navigate().to("https://demoqa.com/radio-button");

        By NoButton = By.xpath("//input[@id='noRadio']");
        //WebElement noButton = driver.findElement(By.xpath("//input[@id='noRadio']"));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click()", driver.findElement(NoButton));
        boolean test3 = driver.findElement(NoButton).isEnabled();
        System.out.print("'" + test3 + "'");


        Assertions.assertEquals(false,test3);
    }


}

