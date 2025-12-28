package tests.logout;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.CommonUtils;

import java.io.IOException;

public class TC_LOGOUT_001 extends BaseTest {

    @Test
    public void verifyLogoutFunctionality() throws IOException {
        login();

        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccountLink();
        homePage.clickLogoutBtn();
        CommonUtils.getScreenshot(driver,"TC_LOGOUT_001");
        homePage.clickMyAccountLink();
        CommonUtils.getScreenshot(driver,"TC_LOGOUT_001");
        Assert.assertEquals(homePage.isLoginDisplayed(),true);
    }
}
