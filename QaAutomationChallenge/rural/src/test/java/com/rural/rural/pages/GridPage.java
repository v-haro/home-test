package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:3100/grid
public class GridPage {




    @FindBy(xpath = "//div[contains(@class, 'item')][7]/h4")
    public WebElement grid7text;

    @FindBy(xpath = "//div[contains(@class, 'item')][7]/p")
    public WebElement grid7Price;




    public GridPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
