package junitTestsPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class webFormFullTesting extends Tests{

    private void browserAddress(){

        //driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        bot.navigate("https://www.selenium.dev/selenium/web/web-form.html");

    }
    @Test
    public void webFormWritingTextInput(){
        browserAddress();
        // writing in text input
        By textInput = By.id("my-text-id");
        bot.type(textInput,"Selenium is Great!");
    }

    @Test
    public void webFormWritingPassword(){
        browserAddress();
        // writing password
        By pass = By.name("my-password");
        bot.type(pass,"876543210");
    }

    @Test
    public void webFormWritingTextArea(){
        browserAddress();
        //writing in text area
        By textArea = By.name("my-textarea");
        WebElement area = driver.findElement(By.name("my-textarea"));
        bot.type(textArea,"This is an example text to fill the text area form");
        area.click();
        String text=area.getText();
        System.out.println(text);
    }

    @Test
    public void webFormSelectingDropDown(){
        browserAddress();

        By dropDown=By.name("my-select");
        Select select = new Select(driver.findElement(dropDown));
        select.selectByValue("1");
        String actualText=select.getAllSelectedOptions().getFirst().getText();
        Assertions.assertEquals("One",actualText);
    }

    @Test
    public void webFormSelectingDropDown2(){
        browserAddress();

        By dropDown=By.name("my-datalist");
        driver.findElement(dropDown).click();
            //Select select=new Select(driver.findElement(dropDown));
            //select.selectByVisibleText("Seattle");
        driver.findElement(dropDown).sendKeys("Seattle");


    }

    @Test
    public void webFormSelectingFile(){
        browserAddress();
        //selecting file
        WebElement fileInput = driver.findElement(By.name("my-file"));
        fileInput.sendKeys("C:/Users/linas/Downloads/IMG_7179.png");
    }

    @Test
    public void webFormSelectingFirstCheckbox(){
        browserAddress();

        By checkbox=By.id("my-check-1");
        driver.findElement(checkbox).click();

        boolean checkBox=driver.findElement(checkbox).isSelected();

        Assertions.assertFalse(checkBox);
    }

    @Test
    public void webFormSelectingSecondCheckbox(){
        browserAddress();

        By checkbox=By.id("my-check-2");
        driver.findElement(checkbox).click();

        boolean checkBox=driver.findElement(checkbox).isSelected();

        Assertions.assertTrue(checkBox);
    }

    @Test
    public void webFormSelectingFirstRadio(){
        browserAddress();

        By radio=By.id("my-radio-1");
        driver.findElement(radio).click();
        boolean radioButton=driver.findElement(radio).isSelected();

        Assertions.assertTrue(radioButton);
    }

    @Test
    public void webFormSelectingSecondRadio(){
        browserAddress();

        By radio=By.id("my-radio-2");
        driver.findElement(radio).click();
        boolean radioButton=driver.findElement(radio).isSelected();

        Assertions.assertTrue(radioButton);
    }

    @Test
    public void webFormReadingText(){
        browserAddress();
        // reading text
        By pageHeader = By.tagName("h1");
        var textValue = driver.findElement(pageHeader).getText();
        Assertions.assertEquals("Web form", textValue);
    }

    @Test
    public void webFormSelectColor(){
        browserAddress();
        var colorPicker = driver.findElement(By.name("my-colors"));
        colorPicker.click();
        colorPicker.sendKeys("#FF0000");
    }

    @Test
    public void webFormDateSelecting(){
        browserAddress();
        var datePicker =driver.findElement(By.name("my-date"));
        datePicker.click();
        var date = By.xpath("/html/body/div/div[1]/table/tbody/tr[5]/td[1]");
        var dateClick=driver.findElement(date);
        dateClick.click();
    }

    @Test
    public void webFormSelectRange(){
        browserAddress();
        var rangeSelector =driver.findElement(By.name("my-range"));
        rangeSelector.sendKeys(Keys.ARROW_LEFT);
    }

    @Test
    public void webFormLink() throws InterruptedException {
        browserAddress();
        var link =driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/div/a"));
        link.click();
        Thread.sleep(5000);

        var secondLink =driver.findElement(By.xpath("/html/body/ul/li[1]/a"));
        secondLink.click();
        Thread.sleep(5000);

        var thirdLink =driver.findElement(By.xpath("/html/body/div/a/strong"));
        thirdLink.click();
        Thread.sleep(5000);
    }

    @Test
    public void webFormButton(){
        browserAddress();
        var button =driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button"));
        button.click();
    }

}
