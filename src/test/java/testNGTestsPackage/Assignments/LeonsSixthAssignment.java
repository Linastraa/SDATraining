package testNGTestsPackage.Assignments;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import testNGTestsPackage.Tests;

import java.io.*;


public class LeonsSixthAssignment extends Tests {

    //Store the path of the file as string and open the file.
//Open the workbook.
//Open the first worksheet.
//Go to the first row.
//Create a cell on the 3rd column (2nd index) on the first row.
//Write “POPULATION” on that cell.
//Create a cell on the 2nd row 3rd cell(index2), and write data.
//Create a cell on the 3rd row 3rd cell(index2), and write data.
//Create a cell on the 4th row 3rd cell(index2), and write data.
//Write and save the workbook.
//Close the file.
//Close the workbook.

//The 3rd column on excel file must be empty before running.
// Otherwise, new data will be written on the old data
    @Test
    public void test() throws IOException {

        Workbook wb = new HSSFWorkbook();
        try  (OutputStream fileOut = new FileOutputStream("Javatpoint.xls")) {
            Sheet sheet1 = wb.createSheet("First Sheet");

            Row row1 = sheet1.createRow(0);
            Row row2 = sheet1.createRow(1);
            Row row3 = sheet1.createRow(2);
            Row row4 = sheet1.createRow(3);
            Row row5 = sheet1.createRow(4);
            Row row6 = sheet1.createRow(5);
            Row row7 = sheet1.createRow(6);
            Row row8 = sheet1.createRow(7);
            Row row9 = sheet1.createRow(8);
            Row row10 = sheet1.createRow(9);

            /****************************************************************************************************************************/

            Cell cell1 = row1.createCell(0);
            cell1.setCellValue("Country");

            Cell cell2 = row1.createCell(1);
            cell2.setCellValue("City");

            Cell cell3 = row1.createCell(2);
            cell3.setCellValue("Population");

            /****************************************************************************************************************************/

            cell1 = row2.createCell(0);
            cell1.setCellValue("Saudi Arabia");

            cell2 = row2.createCell(1);
            cell2.setCellValue("AlTaif");

            cell3 = row2.createCell(2);
            cell3.setCellValue("200000");

            /****************************************************************************************************************************/

            cell1 = row3.createCell(0);
            cell1.setCellValue("Saudi Arabia");

            cell2 = row3.createCell(1);
            cell2.setCellValue("Jeddah");

            cell3 = row3.createCell(2);
            cell3.setCellValue("600000");

            /****************************************************************************************************************************/

            cell1 = row4.createCell(0);
            cell1.setCellValue("Saudi Arabia");

            cell2 = row4.createCell(1);
            cell2.setCellValue("Makkah");

            cell3 = row4.createCell(2);
            cell3.setCellValue("800000");

            /****************************************************************************************************************************/

            cell1 = row5.createCell(0);
            cell1.setCellValue("Saudi Arabia");

            cell2 = row5.createCell(1);
            cell2.setCellValue("Riyadh");

            cell3 = row5.createCell(2);
            cell3.setCellValue("1200000");

            /****************************************************************************************************************************/

            cell1 = row6.createCell(0);
            cell1.setCellValue("Saudi Arabia");

            cell2 = row6.createCell(1);
            cell2.setCellValue("Dammam");

            cell3 = row6.createCell(2);
            cell3.setCellValue("200000");

            /****************************************************************************************************************************/

            cell1 = row7.createCell(0);
            cell1.setCellValue("Saudi Arabia");

            cell2 = row7.createCell(1);
            cell2.setCellValue("Tabuk");

            cell3 = row7.createCell(2);
            cell3.setCellValue("500000");

            /****************************************************************************************************************************/

            cell1 = row8.createCell(0);
            cell1.setCellValue("Saudi Arabia");

            cell2 = row8.createCell(1);
            cell2.setCellValue("Jazan");

            cell3 = row8.createCell(2);
            cell3.setCellValue("400000");

            /****************************************************************************************************************************/

            cell1 = row9.createCell(0);
            cell1.setCellValue("Saudi Arabia");

            cell2 = row9.createCell(1);
            cell2.setCellValue("AlMadinah");

            cell3 = row9.createCell(2);
            cell3.setCellValue("700000");

            /****************************************************************************************************************************/

            cell1 = row10.createCell(0);
            cell1.setCellValue("Saudi Arabia");

            cell2 = row10.createCell(1);
            cell2.setCellValue("AlBahah");

            cell3 = row10.createCell(2);
            cell3.setCellValue("200000");


            wb.write(fileOut);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try (InputStream inp = new FileInputStream("Javatpoint.xls")) {
            Workbook wb1 = WorkbookFactory.create(inp);
            Sheet sheet = wb1.getSheetAt(0);
            Row row = sheet.getRow(2);
            Cell cell = row.getCell(2);
            if (cell != null){
                System.out.println("Data: "+cell);
            }
            else {
                System.out.println("Cell is empty");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }

}
}

