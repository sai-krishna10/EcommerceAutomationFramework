package tests.register;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import base.BaseTest;
import utils.CommonUtils;
import utils.ExcelUtils;

import java.io.IOException;

public class TC_REG_001 extends BaseTest{

    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() throws IOException {
        return ExcelUtils.getRegisterTestData("RegistrationData","TC_REG_001");
    }

    @Test(dataProvider = "registrationData")
    public void verifyRegistrationWithMandatoryFields(
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
        CommonUtils.getScreenshot(driver,"TC_REG_001");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.setFirstNameField(firstName);
        registrationPage.setLastNameField(lastName);
        registrationPage.setEmailField(CommonUtils.generateRandomEmail());
        registrationPage.setTelephoneField(telephone);
        registrationPage.setPasswordField(password);
        registrationPage.setCnfPasswordField(cnfPassword);

        registrationPage.clickPrivacyPolicyCheckBox();
        CommonUtils.getScreenshot(driver,"TC_REG_001");
        registrationPage.clickRegistrationBtn();

        CommonUtils.getScreenshot(driver,"TC_REG_001");
        Assert.assertEquals(homePage.getRegistrationMessage(),successMessage);
    }

}
