package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button/span[contains(text(),'Add to Cart')]")
    WebElement addToCartBtn;

    public void clickAddToCartBtn(){
        waitUntilElementLocated(addToCartBtn);
        addToCartBtn.click();
    }

    public Boolean verifySearchResult(String searchItem){
        String searchResultXpath = "//div[@id='content']/h1[contains(text(),'SearchText')]";
        String newXpath = searchResultXpath.replace("SearchText",searchItem);
        try {
            Boolean searchResult = driver.findElement(By.xpath(newXpath)).isDisplayed();
            return searchResult;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
