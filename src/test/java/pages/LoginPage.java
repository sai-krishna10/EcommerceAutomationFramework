package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-email")
    WebElement emailField;

    @FindBy(id = "input-password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//*[@id='account-login']/div[contains(text(),'No match for E-Mail Address and/or Password.')]")
    WebElement loginFailedMessage;


    public void setEmailField(String email){
        waitUntilElementLocated(emailField);
        emailField.sendKeys(email);
    }

    public void setPasswordField(String password){
        waitUntilElementLocated(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn(){
        waitUntilElementLocated(loginBtn);
        loginBtn.click();
    }

    public boolean isLoginFailedMessageDisplayed(){
        return loginFailedMessage.isDisplayed();
    }
}
