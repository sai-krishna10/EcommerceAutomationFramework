package tests.addcart;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;
import utils.CommonUtils;

import java.io.IOException;

public class TC_ADDCART_001 extends BaseTest {

    @Test
    public void verifyAddCartFunctionality() throws IOException {
        login();

        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        CommonUtils.getScreenshot(driver,"TC_ADDCART_001");
        homePage.searchItem("IPhone");

        CommonUtils.getScreenshot(driver,"TC_ADDCART_001");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickAddToCartBtn();

        CommonUtils.getScreenshot(driver,"TC_ADDCART_001");

        homePage.navigateToHomePage();
        Assert.assertEquals(homePage.getCartCount()>0,true);

    }
}
