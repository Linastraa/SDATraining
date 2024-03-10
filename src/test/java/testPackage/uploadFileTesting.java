package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class uploadFileTesting extends Tests{
    private String url = "https://the-internet.herokuapp.com/upload";
    private String picturePath = "C:\\Users\\linas\\OneDrive\\Desktop\\download.png";

    @Test
    public void uploadFile(){
        logger.info("Navigating to the page : "+url);
        driver.navigate().to(url);
        By fileUploadInput = By.id("file-upload");
        logger.info("Uploading the picture "+picturePath+" to the website");
        driver.findElement(fileUploadInput).sendKeys("C:\\Users\\linas\\OneDrive\\Desktop\\download.png");

        // this code below will not work because the button is inside a form
        //By uploadButton = By.id("file-upload");
        //driver.findElement(uploadButton).click();

        //and instead we can use this code below to click on a button when its inside a form
        driver.findElement(fileUploadInput).submit();
        By label = By.tagName("h3");
        logger.info("Confirming that the picture was uploaded to the website successfully");
        Assertions.assertEquals("File Uploaded!",driver.findElement(label).getText());
    }
}
