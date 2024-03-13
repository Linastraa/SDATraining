package testNGTestsPackage.Assignments;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import testNGTestsPackage.Tests;

public class LeonsFivthAssignment extends Tests {

    @Test
    public void test(){
        //Go to URL: http://facebook.com
        bot.navigate("http://facebook.com");

        //getCookies
        var cookies = driver.manage().getCookies();
        System.out.println("Initial size: " + cookies.size());
        cookies.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------");

        //addCookie
        driver.manage().addCookie(new Cookie("Sulaiman","Trainee"));
        driver.manage().addCookie(new Cookie("Leon","Mentor"));
        cookies = driver.manage().getCookies();
        System.out.println("after first change size: " + cookies.size());
        cookies.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------");

        //deleteCookieNamed
        driver.manage().deleteCookieNamed("Sulaiman");
        cookies = driver.manage().getCookies();
        System.out.println("after second change size: " + cookies.size());
        cookies.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------");

        //deleteAllCookies
        driver.manage().deleteAllCookies();
        cookies = driver.manage().getCookies();
        System.out.println("after last change size: " + cookies.size());
        cookies.forEach(System.out::println);
    }
}
