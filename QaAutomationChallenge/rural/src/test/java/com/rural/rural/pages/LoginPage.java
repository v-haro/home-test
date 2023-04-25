package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:3100/login
public class LoginPage {


    @FindBy(id = "username")
    public WebElement inputUsername;
    
    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "signin-button")
    public WebElement buttonLogin;

    @FindBy(css = "[data-id = 'username']")
    public WebElement pUsername;

    @FindBy(id = "message")
    public WebElement loginFailedMsg;



    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
