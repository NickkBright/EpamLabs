package com.nickkbright.tests;

import com.nickkbright.driver.DriverSetup;
import com.nickkbright.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class HomePageTests extends BaseTest{
    private WebDriver driver;
    private HomePage homepage;


    @BeforeClass
    public void setup() {
        driver = DriverSetup.setDriver();
        homepage = new HomePage(driver);
    }

    @Test
    public void searchTickets() throws InterruptedException{
        homepage.openPage();
        homepage.sendFromInput();
        Thread.sleep(1000);
        homepage.sendToInput();
        Thread.sleep(1000);
        homepage.setDate();
        Thread.sleep(1000);
        homepage.ticketSubmit();


        List<WebElement> trains = driver.findElements(By.className("soln-container"));
        Thread.sleep(1000);
        System.out.println(trains.size());

        Assert.assertNotEquals(trains.size(), 0);
    }


    @Test
    public void searchMilan() throws InterruptedException{
        homepage.openPage();
        homepage.sendSearchInput();
        Thread.sleep(1500);
        homepage.searchSubmit();
        Thread.sleep(1000);
        WebElement results = driver.findElement(By.linkText(homepage.getSearchMilanResults()));
        System.out.println(results.getText());
        Assert.assertEquals(results.getText(), homepage.getSearchMilanResults());
    }

    @Test
    public void changeCurrency() throws InterruptedException{
        homepage.openPage();
        homepage.openCurrencyDropdown();
        Thread.sleep(1000);
        homepage.selectCurrency();
        Thread.sleep(1000);
        homepage.changeCurrency();
        WebElement price = driver.findElement(By.id(homepage.getPriceID()));
        System.out.println(price.getText());
        Assert.assertEquals(price.getText(), "£16");
    }

    @AfterClass
    public void tearDown() {
        DriverSetup.closeDriver();
    }
}
