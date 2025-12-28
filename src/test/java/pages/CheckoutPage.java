package pages;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a/strong[contains(text(),'Checkout')]")
    WebElement checkoutBtn;

    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement finalCheckout;

    public void clickCheckoutBtn(){
        int count =0;
        while(count==0){
            try{
                waitUntilElementLocated(checkoutBtn);
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
                javascriptExecutor.executeScript("arguments[0].click();",checkoutBtn);
                count++;
            }catch (StaleElementReferenceException e){
                System.out.println(e);
            }
        }

    }

    public Boolean verifyCheckoutBtn(){
        try {
            waitUntilElementLocated(finalCheckout);
            finalCheckout.click();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
