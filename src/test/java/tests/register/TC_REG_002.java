package tests.register;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import utils.CommonUtils;
import utils.ExcelUtils;

import java.io.IOException;

public class TC_REG_002 extends BaseTest {
    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() throws IOException {
        return ExcelUtils.getRegisterTestData("RegistrationData","TC_REG_002");
    }

    @Test(dataProvider = "registrationData")
    public void verifyRegistrationWithInvalidConfirmPassword(
            String firstName,
            String lastName,
            String telephone,
            String password,
            String cnfPassword,
            String successMessage
    ) throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccountLink();
        homePage.clickRegisterLink();
        CommonUtils.getScreenshot(driver,"TC_REG_002");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.setFirstNameField(firstName);
        registrationPage.setLastNameField(lastName);
        registrationPage.setEmailField(CommonUtils.generateRandomEmail());
        registrationPage.setTelephoneField(telephone);
        registrationPage.setPasswordField(password);
        registrationPage.setCnfPasswordField(cnfPassword);

        registrationPage.clickPrivacyPolicyCheckBox();
        CommonUtils.getScreenshot(driver,"TC_REG_002");
        registrationPage.clickRegistrationBtn();
        CommonUtils.getScreenshot(driver,"TC_REG_002");

        homePage.clickMyAccountLink();
        CommonUtils.getScreenshot(driver,"TC_REG_002");
        Assert.assertEquals(homePage.isLogoutDisplayed(),false);
    }
}
