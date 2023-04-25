package com.rural.rural;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumTools {



    public static void selectFromListForVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public static void markAsChecked(WebElement checkbox, WebDriver driver){

        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('checked', 'true')", checkbox);

    }

    public static void markAsUnchecked(WebElement checkbox, WebDriver driver){

        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('checked', 'false')", checkbox);

    }

    public static String getAlertMessage(WebDriver driver){
        // Switch to the alert window
        Alert alert = driver.switchTo().alert();
        // Get the text of the alert message
        String alertText = alert.getText();
        // Confirm the alert by clicking on the OK button
        alert.accept();
        // Close the alert window
        driver.switchTo().defaultContent();
        // Switch back to the main content of the webpage
        driver.switchTo().defaultContent();

        return alertText;
    }

    public static boolean waitUntilTextPresentInElement(WebDriver driver,WebElement el, String word){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
        Boolean resultElement = wait.until(ExpectedConditions.textToBePresentInElement(el, word));

        return resultElement;

    }


}
