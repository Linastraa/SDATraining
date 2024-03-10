package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class cookiesTesting extends Tests{

    @Test
    public void cookies(){
        driver.navigate().to("https://kitchen.applitools.com/ingredients/cookie");
        var cookies = driver.manage().getCookies();
        System.out.println("Initial size: " + cookies.size());
        cookies.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------");

        driver.manage().addCookie(new Cookie("fruit","apple"));
        driver.manage().addCookie(new Cookie("protein","meat"));
        cookies = driver.manage().getCookies();
        System.out.println("after first change size: " + cookies.size());
        cookies.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------");

        //edit the "protein" cookie to have the value "meat"

        driver.manage().deleteCookieNamed("vegetable");
        cookies = driver.manage().getCookies();
        System.out.println("after second change size: " + cookies.size());
        cookies.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------");

        driver.manage().deleteAllCookies();
        cookies = driver.manage().getCookies();
        System.out.println("after last change size: " + cookies.size());
        cookies.forEach(System.out::println);


        Assertions.assertEquals(0,cookies.size());

    }
}
