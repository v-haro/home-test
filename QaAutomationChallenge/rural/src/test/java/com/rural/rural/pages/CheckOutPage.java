package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:3100/checkout
public class CheckOutPage {
    
    
    @FindBy(id = "cname")
    public WebElement inputCname;

    @FindBy(name = "cardnumber")
    public WebElement inputCcnum;

    @FindBy(id = "expmonth")
    public WebElement selectExpmonth;

    @FindBy(id = "cvv")
    public WebElement inputCvv;

    @FindBy(id = "expyear")
    public WebElement inputExpyear;

    @FindBy(id = "fname")
    public WebElement inputFirstname;

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "adr")
    public WebElement inputAdr;

    @FindBy(id = "city")
    public WebElement inputCity;

    @FindBy(id = "zip")
    public WebElement inputZip;

    @FindBy(id = "state")
    public WebElement inputState;

    @FindBy(name = "sameadr")
    public WebElement inputSameadr;

    @FindBy(xpath = "//button")
    public WebElement buttonContinueCheckout;

    @FindBy(css = "h1")
    public WebElement h1OrderConfirmed;

    @FindBy(id = "result")
    public WebElement Result;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/p[1]/span")
    public WebElement spanPrice;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/h4/span/b")
    public WebElement itemsInCar;

    @FindBy(xpath = "//p[contains(text(), 'Total')]//span")
    public WebElement cartTotal;
    

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
