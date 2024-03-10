package testPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LeonTask_dropDownTesting extends Tests{

    @Test
    public void radioButtonVerification3() {
        driver.navigate().to("https://demoqa.com/select-menu");
        By menu = By.id("oldSelectMenu");
        Select select=new Select(driver.findElement(menu));

        //Get all the options of the dropdown
        List<WebElement> optionList = select.getOptions();
        for(WebElement e : optionList) {

            //Print all test
            System.out.print(e.getText()+" ");
        }

        //Options size
        int size=select.getOptions().size();
        System.out.println("\n"+size);

        //Verify the dropdown has option "Black"
        WebElement text = driver.findElement(By.id("oldSelectMenu"));
        boolean actual =text.getText().contains("Black");
        System.out.println(actual);

        //Print FirstSelectedOptionTest
        System.out.println(select.getFirstSelectedOption().getText());

        //Select option "Yellow"
        select.selectByVisibleText("Yellow");
        System.out.println(select.getFirstSelectedOption().getText());
    }

}

