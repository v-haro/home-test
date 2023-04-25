package com.rural.rural.testcases;

import com.rural.rural.SeleniumTools;
import com.rural.rural.pages.CheckOutPage;
import com.rural.rural.pages.GridPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class GridTest {
    private WebDriver driver;
    private GridPage gridPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:3100/grid");

        gridPage = new GridPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void grid1() throws InterruptedException {

        SeleniumTools st = new SeleniumTools();


        Assert.assertTrue(gridPage.grid7text.getText().equals("Super Pepperoni"),"grid7 doesn't contains Super Pepperoni");
        Assert.assertTrue(Integer.parseInt(gridPage.grid7Price.getText().substring(1))==10, "price in grid7 is not 10");
    }

    @Test
    public void grid2(){

        List<WebElement> items = driver.findElements(By.xpath("//div[@id='menu']/div[@class='item']"));

        for (WebElement item : items) {
            WebElement titleElement = item.findElement(By.xpath(".//h4[@data-test-id='item-name']"));
            String title = titleElement.getText();
            Assert.assertFalse(title.isEmpty(), "Item title is empty");

            WebElement priceElement = item.findElement(By.xpath(".//p[@id='item-price']"));
            String price = priceElement.getText().replace("$", "");
            Assert.assertFalse(price.isEmpty(), "Item price is empty");

            WebElement imageElement = item.findElement(By.xpath(".//img"));
            String imageSource = imageElement.getAttribute("src");
            Assert.assertFalse(imageSource.isEmpty(), "Item image is empty");

            WebElement buttonElement = item.findElement(By.xpath(".//button[@data-test-id='add-to-order']"));
            Assert.assertNotNull(buttonElement, "Add to Order button not found");
        }
    }

}
