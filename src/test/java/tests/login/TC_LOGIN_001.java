package tests.login;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import base.BaseTest;
import utils.CommonUtils;
import utils.ExcelUtils;

import java.io.IOException;

public class TC_LOGIN_001 extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        return ExcelUtils.getLoginData("LoginData","TC_LOGIN_001");
    }

    @Test(dataProvider = "loginData")
    public void verifyLoginWithValidCredentials(
            String email,
            String password
    ) throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccountLink();
        CommonUtils.getScreenshot(driver,"TC_LOGIN_001");
        homePage.clickLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmailField(email);
        loginPage.setPasswordField(password);
        CommonUtils.getScreenshot(driver,"TC_LOGIN_001");
        loginPage.clickLoginBtn();
        homePage.clickMyAccountLink();
        CommonUtils.getScreenshot(driver,"TC_LOGIN_001");
        Assert.assertEquals(homePage.isLogoutDisplayed(),true);
    }
}
