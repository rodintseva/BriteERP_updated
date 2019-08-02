package com.cybertek.tests.loginpage;


import com.cybertek.pages.loginpage.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {




    @Test
    public void Test1(){
        LoginPage loginpage = new LoginPage();
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginpage.login(username,password);

    }


    @Test
    public void negativeLoginTest1(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrongusername", "wrongpassword");
        String message = loginPage.errorMessageElement.getText().trim();
        Assert.assertEquals(message, "Wrong login/password");
    }




}
