package com.nickkbright.tests;


import com.nickkbright.driver.DriverSetup;
import com.nickkbright.pages.TrainTravelGuidePage;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TrainTravelGuideTests {
    private final String HEADER_XPATH_ANCHOR = "/html/body/div[1]/div[2]/div/section/div/article/div/div/h3[2]";
    private final String HEADER_XPATH_INFO = "/html/body/div[1]/div[2]/h1";
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
        WebElement header = driver.findElement(By.xpath(HEADER_XPATH_ANCHOR));
        System.out.println(header.getText());
        Assert.assertEquals(header.getText(), "Should I purchase a rail pass or city to city tickets?");
    }

    @Test
    public void checkShippingInfo() throws InterruptedException {
        guidepage.openPage();
        Thread.sleep(2000);
        guidepage.clickShippingInfo();
        Thread.sleep(2000);
        WebElement header = driver.findElement(By.xpath(HEADER_XPATH_INFO));
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
        WebElement header = driver.findElement(By.xpath(HEADER_XPATH_INFO));
        System.out.println(header.getText());
        Assert.assertEquals(header.getText(), "Bicycles on Trains in Italy");
    }

    @After
    public void tearDown(){
        DriverSetup.closeDriver();
    }
}
