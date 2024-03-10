package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeonTask_alertsTesting extends Tests{

    @Test
    public void alertsTesting(){
        //Go to URL: http://demo.automationtesting.in/Alerts.html
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");

       //Click "Alert with OK" and click 'click the button to display an alert box
        By alertWithOkbutton = By.xpath("//button[@onclick='alertbox()']");
        driver.findElement(alertWithOkbutton).click();

        //Accept Alert(I am an alert box!) and print alert on console.
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        System.out.println(text);

        //Click "Alert with OK & Cancel" and click 'click the button to display a confirm box
        By alertWithOkAndCancelLink = By.xpath("//a[@href='#CancelTab']");
        driver.findElement(alertWithOkAndCancelLink).click();
        By alertWithOkAndCancelButton = By.xpath("//button[@onclick='confirmbox()']");
        driver.findElement(alertWithOkAndCancelButton).click();

        //Cancel Alert (Press a Button !)
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        By message = By.xpath("//p[@id='demo']");
        String actualMessage = driver.findElement(message).getText();
        System.out.println(actualMessage);

        //Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box
        By alertWithTextBoxLink = By.xpath("//a[@href='#Textbox']");
        driver.findElement(alertWithTextBoxLink).click();
        By alertWithTextBoxButton = By.xpath("//button[@onclick='promptbox()']");
        driver.findElement(alertWithTextBoxButton).click();

        //And then sendKeys «Bootcamp» (Please enter your name)
        alert.sendKeys("«Bootcamp» Sulaiman Ahmed Alzahrani");
        alert.accept();

        //Finally print on console this message "Hello Bootcamp How are you today" assertion these message.
        By message1 = By.xpath("//p[@id='demo1']");
        String actualMessage1 = driver.findElement(message1).getText();
        System.out.println(actualMessage1);
        Assertions.assertEquals("Hello «Bootcamp» Sulaiman Ahmed Alzahrani How are you today",actualMessage1);
    }

}
