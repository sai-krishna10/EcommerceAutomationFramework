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

public class TC_LOGIN_002 extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        return ExcelUtils.getLoginData("LoginData","TC_LOGIN_002");
    }

    @Test(dataProvider = "loginData")
    public void verifyLoginWithInValidCredentials(
            String email,
            String password
    ) throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        CommonUtils.getScreenshot(driver,"TC_LOGIN_002");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmailField(email);
        loginPage.setPasswordField(password);
        CommonUtils.getScreenshot(driver,"TC_LOGIN_002");
        loginPage.clickLoginBtn();

        homePage.clickMyAccountLink();
        CommonUtils.getScreenshot(driver,"TC_LOGIN_002");

        Assert.assertEquals(loginPage.isLoginFailedMessageDisplayed(),true);
    }
}
