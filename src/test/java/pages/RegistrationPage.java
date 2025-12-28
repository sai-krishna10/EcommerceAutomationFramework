package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    WebElement firstNameField;

    @FindBy(id = "input-lastname")
    WebElement lastNameField;

    @FindBy(id = "input-email")
    WebElement emailField;

    @FindBy(id = "input-telephone")
    WebElement telephoneField;

    @FindBy(id = "input-password")
    WebElement passwordField;

    @FindBy(id = "input-confirm")
    WebElement cnfPasswordField;

    @FindBy(name = "agree")
    WebElement privacyPolicyCheckBox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueBtn;


    public void setFirstNameField(String firstName){
        waitUntilElementLocated(firstNameField);
        firstNameField.sendKeys(firstName);
    }

    public void setLastNameField(String lastName){
        waitUntilElementLocated(lastNameField);
        lastNameField.sendKeys(lastName);
    }

    public void setEmailField(String email){
        waitUntilElementLocated(emailField);
        emailField.sendKeys(email);
    }

    public void setTelephoneField(String phone){
        waitUntilElementLocated(telephoneField);
        telephoneField.sendKeys(phone);
    }

    public void setPasswordField(String password){
        waitUntilElementLocated(passwordField);
        passwordField.sendKeys(password);
    }

    public void setCnfPasswordField(String cnfPassword){
        waitUntilElementLocated(cnfPasswordField);
        cnfPasswordField.sendKeys(cnfPassword);
    }

    public void clickPrivacyPolicyCheckBox(){
        waitUntilElementLocated(privacyPolicyCheckBox);
        privacyPolicyCheckBox.click();
    }

    public void clickRegistrationBtn(){
        waitUntilElementLocated(continueBtn);
        continueBtn.click();
    }

}
