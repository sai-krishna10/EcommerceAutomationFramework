package base;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public Properties properties;

    @BeforeSuite
    public void generateFolderName(){
        CommonUtils.initScreenshotFolder();
    }

    @BeforeMethod
    public void invokeApplication() throws IOException {
        CommonUtils utils = new CommonUtils();
        properties = utils.getProperties();
        String browser = properties.getProperty("browser");

        if(properties.getProperty("browser").equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if(properties.getProperty("browser").equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }else{
            driver = new FirefoxDriver();
        }

        String url=properties.getProperty("appURL");
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownApplication(){
        driver.quit();
    }

    public void login() throws IOException {
        String email;
        String password;

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testdata/TestData.xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("CommonLogin");
        email = sheet.getRow(1).getCell(0).toString();
        password=sheet.getRow(1).getCell(1).toString();

        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccountLink();
        homePage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmailField(email);
        loginPage.setPasswordField(password);
        loginPage.clickLoginBtn();
    }


}
