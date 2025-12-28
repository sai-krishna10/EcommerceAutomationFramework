package tests.search;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;
import utils.CommonUtils;
import utils.ExcelUtils;

import java.io.IOException;

public class TC_SEARCH_001 extends BaseTest{

    @DataProvider(name = "searchData")
    public Object[][] getSearchData() throws IOException {
        return ExcelUtils.getSearchData("SearchData","TC_SEARCH_001");
    }

    @Test(dataProvider = "searchData")
    public void verifySearchResults(String searchItem) throws IOException {
        login();
        CommonUtils.getScreenshot(driver,"TC_SEARCH_001");
        HomePage homePage = new HomePage(driver);
        homePage.searchItem(searchItem);
        CommonUtils.getScreenshot(driver,"TC_SEARCH_001");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assert.assertEquals(searchResultPage.verifySearchResult(searchItem),true);
    }
}
