package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='My Account']")
    WebElement myAccountLink;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement registerLink;

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement loginLink;

    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement registrationCnfMessage;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutLink;

    @FindBy(name = "search")
    WebElement searchInput;

    @FindBy(xpath = "//div[@id='search']/span/button")
    WebElement searchBtn;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutBtn;

    @FindBy(xpath = "//a[contains(text(),'Qafox.com')]")
    WebElement homeLink;

    @FindBy(xpath = "//div[@id='cart']/button")
    WebElement cartBtn;

    @FindBy(xpath = "//*[@id='cart-total']")
    WebElement cartText;


    public void clickMyAccountLink(){
        int count=0;
        while(count==0){
            try{
                waitUntilElementLocated(myAccountLink);
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
                javascriptExecutor.executeScript("arguments[0].click();",myAccountLink);
                count++;
            } catch (StaleElementReferenceException e) {
                System.out.println(e);
            }
        }
    }

    public void clickRegisterLink(){
        waitUntilElementLocated(registerLink);
        registerLink.click();
    }

    public void clickLoginLink(){
        waitUntilElementLocated(loginLink);
        loginLink.click();
    }

    public String getRegistrationMessage(){
        waitUntilElementLocated(registrationCnfMessage);
        return registrationCnfMessage.getText();
    }

    public Boolean isLogoutDisplayed(){
        try{
            return logoutLink.isDisplayed();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void searchItem(String searchTxt){
        int count = 0;
        while (count==0){
            try {
                waitUntilElementLocated(searchInput);
                searchInput.sendKeys(searchTxt);
                waitUntilElementLocated(searchBtn);
                searchBtn.click();
                count++;
            } catch (StaleElementReferenceException e) {
                System.out.println(e);
            }
        }
    }

    public void clickLogoutBtn(){
        waitUntilElementLocated(logoutBtn);
        logoutBtn.click();
    }

    public Boolean isLoginDisplayed() {
        try {
            loginLink.isDisplayed();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void navigateToHomePage(){
        int count=0;
        while (count==0){
            try {
                waitUntilElementLocated(homeLink);
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
                javascriptExecutor.executeScript("arguments[0].click();",homeLink);
                count++;
            } catch (StaleElementReferenceException e) {
                System.out.println(e);
            }
        }
    }

    public void clickCartBtn(){
        waitUntilElementLocated(cartBtn);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click();",cartBtn);
    }

    public int getCartCount(){
        int count=0;
        while (count==0){
            try{
                waitUntilElementLocated(cartText);
                count++;
                return Integer.parseInt(cartText.getText().substring(0,1));
            } catch (StaleElementReferenceException e) {
                System.out.println(e);
            }
        }
        return 0;
    }
}
