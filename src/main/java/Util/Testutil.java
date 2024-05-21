package Util;

import Base.Testbase;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Testutil extends Testbase {


    public static long Pageloadtimeout = 10;
    public static long implicitlywait = 10;
    static Workbook book;
    static Sheet sheet;

    public static String sheetpath = "D:\\intellij_workspace\\React-pom\\src\\main\\java\\Testdata\\react_testdata.xlsx";

    public static Object[][] getbookname(String sheetname) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(sheetpath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            book = WorkbookFactory.create(fis);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = book.getSheet(sheetname);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }

    public void captureScreenshot(String methodName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File SFile = ts.getScreenshotAs(OutputType.FILE);
        File DFile = new File("D:\\intellij_workspace\\React-pom\\Screenshot\\"+methodName+".png" );
        FileHandler.copy(SFile, DFile);


    }


}