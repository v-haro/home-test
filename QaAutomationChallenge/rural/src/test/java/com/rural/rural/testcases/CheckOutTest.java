package com.rural.rural.testcases;

import com.rural.rural.SeleniumTools;
import com.rural.rural.pages.CheckOutPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckOutTest {
    private WebDriver driver;
    private CheckOutPage checkOutPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:3100/checkout");

        checkOutPage = new CheckOutPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test(dataProvider = "checkoutData", dataProviderClass = dataProvider.DataProviderFromJson.class)
    public void checkOutFormAlert(dataDefinition.MyCheckOutData myCheckOutData) throws InterruptedException {

        SeleniumTools st = new SeleniumTools();

        checkOutPage.inputCname.sendKeys(myCheckOutData.name_on_card);
        checkOutPage.inputCcnum.sendKeys(myCheckOutData.credit_card_number);
        st.selectFromListForVisibleText(checkOutPage.selectExpmonth, myCheckOutData.exp_month);
        checkOutPage.inputCvv.sendKeys(myCheckOutData.cvv);
        checkOutPage.inputExpyear.sendKeys(myCheckOutData.exp_year);
        checkOutPage.inputExpyear.sendKeys(myCheckOutData.exp_month);
        checkOutPage.inputFirstname.sendKeys(myCheckOutData.fullname);
        checkOutPage.inputEmail.sendKeys(myCheckOutData.email);
        checkOutPage.inputAdr.sendKeys(myCheckOutData.address);
        checkOutPage.inputState.sendKeys(myCheckOutData.state);
        checkOutPage.inputCity.sendKeys(myCheckOutData.city);
        checkOutPage.inputZip.sendKeys(myCheckOutData.zip);

        // verify that the checkbox is selected (checked)
        st.markAsChecked(checkOutPage.inputSameadr, driver);
        Assert.assertTrue(checkOutPage.inputSameadr.isSelected(), "The checkbox is not selected.");
        checkOutPage.inputSameadr.click();
        st.markAsUnchecked(checkOutPage.inputSameadr, driver);

        //click on continue checkout
        checkOutPage.buttonContinueCheckout.click();
        String alertText = st.getAlertMessage(driver);
        Assert.assertTrue(alertText.equals("Shipping address same as billing checkbox must be selected."));

        //marcando el check box nuevamente
        checkOutPage.inputSameadr.click();
        st.markAsChecked(checkOutPage.inputSameadr, driver);
        //click en el boton de checkout
        checkOutPage.buttonContinueCheckout.click();
        String checkoutMsj = checkOutPage.h1OrderConfirmed.getText();
        // verify if the checkout is successful
        try {
            Assert.assertTrue(checkoutMsj.equals("Order Confirmed!"), "the checkout was unsuccessful");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
        // close the browser
        driver.quit();

    }

    @Test
    public void carTotalTest() {

        String itemsInCart = checkOutPage.itemsInCar.getText();
        int itemsInCartint = Integer.parseInt(itemsInCart);
        int totalValue = 0;
        int priceValue = 0;
        WebElement el;
        for (int i = 1; i <= itemsInCartint; i++) {

            el = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/p[" + i + "]/span"));
            String value = el.getText();

            priceValue = Integer.parseInt(value.substring(1));
            System.out.println("price value of " + i + ":" + priceValue);
            totalValue = totalValue + priceValue;
            System.out.println("total value of " + i + ":" + totalValue);
        }

        String cT = checkOutPage.cartTotal.getText();
        int cartTotal = Integer.parseInt(cT.substring(1));

        try {
            Assert.assertTrue(totalValue == cartTotal, "the total value is wrong");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }

    }

}
