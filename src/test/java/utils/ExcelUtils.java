package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static Object[][] getRegisterTestData(String sheetName,String testcase) throws IOException {

        FileInputStream file = new FileInputStream(
                System.getProperty("user.dir")
                        + "/src/test/resources/testdata/TestData.xlsx"
        );

        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();
        int testcaseRowNumber=0;

        Object[][] registrationData = new Object[1][cols-1];

        for(int i=1;i<rows;i++){
            if(sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(testcase)){
                testcaseRowNumber= i;
                break;
            }
        }
        if(testcaseRowNumber>0){
            for (int j = 1; j < cols; j++) {
                registrationData[0][j-1] = sheet.getRow(testcaseRowNumber).getCell(j).toString();
            }
        }else{
            throw new RuntimeException("Test Data for "+testcase+" is not found");
        }

        workbook.close();
        file.close();

        return registrationData;
    }

    public static Object[][] getLoginData(String sheetName,String testcase) throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/resources/testdata/TestData.xlsx");

        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        int testcaseRowNumber=0;

        Object[][] loginData = new Object[1][cols-1];

        for(int i=1;i<rows;i++){
            if(sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(testcase)){
                testcaseRowNumber= i;
                break;
            }
        }

        if(testcaseRowNumber>0){
            for (int j = 1; j < cols; j++) {
                loginData[0][j-1] = sheet.getRow(testcaseRowNumber).getCell(j).toString();
            }
        }else{
            throw new RuntimeException("Test Data for "+testcase+" is not found");
        }


        workbook.close();
        file.close();
        return loginData;
    }

    public static Object[][] getSearchData(String sheetName,String testcase) throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/resources/testdata/TestData.xlsx");

        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        int testcaseRowNumber=0;

        Object[][] searchData = new Object[1][cols-1];

        for(int i=1;i<rows;i++){
            if(sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(testcase)){
                testcaseRowNumber= i;
                break;
            }
        }

        if(testcaseRowNumber>0){
            for (int j = 1; j < cols; j++) {
                searchData[0][j-1] = sheet.getRow(testcaseRowNumber).getCell(j).toString();
            }
        }else{
            throw new RuntimeException("Test Data for "+testcase+" is not found");
        }


        workbook.close();
        file.close();
        return searchData;
    }
}
