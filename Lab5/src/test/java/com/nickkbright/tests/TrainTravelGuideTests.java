package com.nickkbright.tests;


import com.nickkbright.driver.DriverSetup;
import com.nickkbright.pages.TrainTravelGuidePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TrainTravelGuideTests extends BaseTest{

    private WebDriver driver;
    private TrainTravelGuidePage guidepage;

    @BeforeClass
    private void setup() {
        driver = DriverSetup.setDriver();
        guidepage = new TrainTravelGuidePage(driver);
    }

    @Test
    public void checkAnchor() throws InterruptedException {
        guidepage.openPage();
        Thread.sleep(2000);
        guidepage.clickAnchor();
        Thread.sleep(2000);
        WebElement header = driver.findElement(By.xpath(guidepage.getHeaderAnchorXpath()));
        System.out.println(header.getText());
        Assert.assertEquals(header.getText(), "Should I purchase a rail pass or city to city tickets?");
    }

    @Test
    public void checkShippingInfo() throws InterruptedException {
        guidepage.openPage();
        Thread.sleep(2000);
        guidepage.clickShippingInfo();
        Thread.sleep(2000);
        WebElement header = driver.findElement(By.xpath(guidepage.getHeaderInfo()));
        System.out.println(header.getText());
        Assert.assertEquals(header.getText(), "Shipping Information");
    }

    @Test
    public void checkBicyclesInfo() throws InterruptedException {
        guidepage.openPage();
        Thread.sleep(2000);
        guidepage.scrollBicycleInfo();
        Thread.sleep(2000);
        guidepage.clickBicycleInfo();
        Thread.sleep(2000);
        WebElement header = driver.findElement(By.xpath(guidepage.getHeaderInfo()));
        System.out.println(header.getText());
        Assert.assertEquals(header.getText(), "Bicycles on Trains in Italy");
    }

    @AfterClass
    public void tearDown(){
        DriverSetup.closeDriver();
    }
}
