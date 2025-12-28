package tests.checkout;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SearchResultPage;
import utils.CommonUtils;

import java.io.IOException;

public class TC_CHECKOUT_001 extends BaseTest {

    @Test
    public void verifyCheckoutFunctionality() throws IOException {
        login();
        HomePage homePage = new HomePage(driver);
        homePage.searchItem("Iphone");

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickAddToCartBtn();
        CommonUtils.getScreenshot(driver,"TC_CHECKOUT_001");
        homePage.clickCartBtn();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutBtn();

        CommonUtils.getScreenshot(driver,"TC_CHECKOUT_001");
        Assert.assertEquals(checkoutPage.verifyCheckoutBtn(),true);
    }
}
