package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:3100/search
public class SearchPage {

    @FindBy(name = "searchWord")
    public WebElement inputSearchWord;

    @FindBy(xpath = "//button")
    public WebElement button;

    @FindBy(id = "result")
    public WebElement pResult;



    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
