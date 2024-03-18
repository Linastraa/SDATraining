package testNGTestsPackage.Assignments2;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testNGTestsPackage.Tests;

import java.io.FileInputStream;
import java.io.IOException;

public class Task2Tests extends Tests {
    @Test(dataProvider = "notesData")
    public void addNoteTest(String noteTitle, String noteContent) {
        bot.navigate("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");

        By titleInput = By.id("note-title-input");
        By contentInput = By.id("note-details-input");
        By addButton = By.id("add-note");

        bot.type(titleInput,noteTitle);
        bot.type(contentInput,noteContent);
        bot.click(addButton);
    }

    @DataProvider(name = "notesData")
    public Object[][] getNotesData() throws IOException {
        String path = "C:\\Users\\linas\\IdeaProjects\\WebElementsTesting\\src\\test\\resources\\testData\\";
        FileInputStream fis = new FileInputStream(path+"Task2.xls");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rows][2];

        for (int i = 0; i < rows; i++) {
            Row row = sheet.getRow(i);
            data[i][0] = row.getCell(0).getStringCellValue(); // Note Title
            data[i][1] = row.getCell(1).getStringCellValue(); // Note Content
        }
        workbook.close();
        fis.close();
        return data;
    }
}
