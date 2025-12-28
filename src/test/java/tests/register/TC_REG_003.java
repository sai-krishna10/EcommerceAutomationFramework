package tests.register;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import utils.CommonUtils;

import java.io.IOException;

public class TC_REG_003 extends BaseTest {

    @Test
    public void verifyRegistrationWithEmptyFields() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccountLink();
        homePage.clickRegisterLink();
        CommonUtils.getScreenshot(driver,"TC_REG_003");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegistrationBtn();
        CommonUtils.getScreenshot(driver,"TC_REG_003");
        Assert.assertEquals(homePage.isLogoutDisplayed(),false);
    }
}
