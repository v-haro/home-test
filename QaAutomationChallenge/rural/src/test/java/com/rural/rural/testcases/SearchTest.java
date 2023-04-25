package com.rural.rural.testcases;

import com.rural.rural.SeleniumTools;
import com.rural.rural.pages.CheckOutPage;
import com.rural.rural.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest {
    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:3100/search");

        searchPage = new SearchPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void searchSuccess() throws InterruptedException {

        String world="automation";
        SeleniumTools st = new SeleniumTools();
        searchPage.inputSearchWord.sendKeys(world);
        searchPage.button.click();
        st.waitUntilTextPresentInElement(driver, searchPage.pResult, "Found");
        searchPage.pResult.getText();
        Assert.assertTrue(searchPage.pResult.getText().equals("Found one result for ".concat(world)),"the result is diferent from the expected");
        

    }

    @Test
    public void searchEmpty(){

        SeleniumTools st = new SeleniumTools();
        searchPage.button.click();
        st.waitUntilTextPresentInElement(driver, searchPage.pResult, "Please provide a search word.");
        searchPage.pResult.getText();
        Assert.assertTrue(searchPage.pResult.getText().equals("Please provide a search word."),"the result is diferent from the expected");


    }

}
