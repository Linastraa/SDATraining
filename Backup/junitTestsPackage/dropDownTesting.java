package junitTestsPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class dropDownTesting extends Tests{




    @Test
    public void webFormButton(){
        bot.navigate("https://the-internet.herokuapp.com/dropdown");

        By dr1 = By.id("dropdown");
        Select select = new Select(driver.findElement(dr1));
        select.selectByIndex(1);
        boolean isSelected1 = select.getFirstSelectedOption().isSelected();
        System.out.println(isSelected1);

        select.selectByIndex(2);
        boolean isSelected2 = select.getFirstSelectedOption().isSelected();
        System.out.println(isSelected2);
        System.out.println(select.getFirstSelectedOption().getText());
    }

}
