package testNGTestsPackage.Assignments2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testNGTestsPackage.base.Tests;

public class Task5Tests extends Tests {

    @Test
    public void test(){
        //Go to URL: http://crossbrowsertesting.github.io/
        bot.navigate("http://crossbrowsertesting.github.io/");

        //Click to To-Do App
        By link = By.xpath("//a[@href='todo-app.html']");
        bot.click(link);

        //Checking Box to do-4 and Checking Box to do-5
        By fourthCheckbox = By.xpath("//input[@name='todo-4']");
        By fifthCheckbox = By.xpath("//input[@name='todo-5']");
        bot.click(fourthCheckbox);
        bot.click(fifthCheckbox);

        //If both clicks worked, then the following List should be have length 2.
        By numberOfSelectedCheckbox = By.xpath("//span[@class='done-true']");
        int count = driver.findElements(numberOfSelectedCheckbox).size();
        SoftAssert softAssert=new SoftAssert();
        //Assert that this is correct
        softAssert.assertEquals(count,2);

        By textField = By.id("todotext");
        By addButton = By.id("addbutton");
        bot.type(textField,"test");
        bot.click(addButton);
        By test = By.xpath("//span[@class='done-false' and text()='test']");
        //Assert that the to do we added is present in the list
        softAssert.assertTrue(driver.findElement(test).isDisplayed());

        //Archiving old todos
        By archive = By.xpath("//a[text()='archive']");
        bot.click(archive);

        //If our archive link worked, then the following list should have length 4.
        By numberOfUnSelectedCheckbox = By.xpath("//span[@class='done-false']");
        int count1 = driver.findElements(numberOfUnSelectedCheckbox).size();
        //Assert that this is true as well
        softAssert.assertEquals(count1,4);

        softAssert.assertAll();

        //Doing Cross Browser Testing.
        /**
         * provided in the task5.xml file
         */
    }
}
