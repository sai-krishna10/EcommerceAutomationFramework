package tests.login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

import java.io.IOException;

public class TC_LOGIN_003 extends BaseTest {

    @Test
    public void verifyLoginWithEmptyCredentials() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        CommonUtils.getScreenshot(driver,"TC_LOGIN_003");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginBtn();
        CommonUtils.getScreenshot(driver,"TC_LOGIN_003");
        Assert.assertEquals(homePage.isLogoutDisplayed(),false);
    }
}
