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


public class SearchTest {
    private WebDriver driver;
    private HomePage homepage;


    @BeforeClass
    public void setup() {
       driver = DriverSetup.setDriver();
        homepage = new HomePage(driver);
    }

    @Test
    public void searchMilan() throws InterruptedException{
        homepage.openPage();
        homepage.sendSearchInput();
        Thread.sleep(1500);
        homepage.searchSubmit();
        Thread.sleep(1000);
        WebElement results = driver.findElement(By.linkText("Train from Milan Malpensa Airport to Milan"));
        System.out.println(results.getText());
        Assert.assertEquals(results.getText(), "Train from Milan Malpensa Airport to Milan");
    }

    @AfterClass
    public void tearDown() {
        DriverSetup.closeDriver();
    }
}

