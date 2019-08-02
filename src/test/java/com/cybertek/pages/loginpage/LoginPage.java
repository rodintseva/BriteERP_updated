package com.cybertek.pages.loginpage;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Long.valueOf(ConfigurationReader.getProperty("explicitwait")));

    @FindBy(id = "login")
    public WebElement userNameElement;

    @FindBy(id = "password")
    public WebElement passwordElement;

    @FindBy(css=".btn.btn-primary")
    public WebElement loginButtonElement;

    @FindBy(css = ".alert.alert-danger")
    public WebElement errorMessageElement;



    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String username, String password){
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }


}
