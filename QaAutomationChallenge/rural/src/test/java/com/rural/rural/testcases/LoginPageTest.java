package com.rural.rural.testcases;

import com.rural.rural.pages.LoginPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:3100/login");

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "userdata", dataProviderClass = dataProvider.DataProviderFromJson.class)
    public void loginSuccess(dataDefinition.MyUserData userData) {
        loginPage.inputUsername.sendKeys(userData.username);
        loginPage.inputPassword.sendKeys(userData.password);
        loginPage.buttonLogin.click();
        String loginMsj=loginPage.pUsername.getText();

        // verify if the login is successful
        Assert.assertTrue(loginMsj.equals(userData.username), "Login was successful!");

        // close the browser
        driver.quit();

    }


    @Test(dataProvider = "userdataFailed", dataProviderClass = dataProvider.DataProviderFromJson.class)
    public void loginFailureA(dataDefinition.MyUserData userData) {
        loginPage.inputUsername.sendKeys(userData.username);
        loginPage.inputPassword.sendKeys(userData.password);
        loginPage.buttonLogin.click();
        String loginMsj=loginPage.loginFailedMsg.getText();

        // Assert if the login is unsuccessful
        Assert.assertFalse(loginMsj.equals("Wrong credentials"), "Login error A feature is wrong.");

        // close the browser
        driver.quit();

    }

    @Test
    public void loginFailureB() {

        loginPage.buttonLogin.click();
        String loginMsj=loginPage.loginFailedMsg.getText();

        // Assert if the login is unsuccessful
        Assert.assertFalse(loginMsj.equals("Fields can not be empty"), "Login error B feature is wrong.");

        // close the browser
        driver.quit();

    }


}
