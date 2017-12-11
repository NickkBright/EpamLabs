package com.nickkbright.tests;


import com.nickkbright.driver.DriverSetup;
import com.nickkbright.pages.DealsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DealsTests {

    private WebDriver driver;
    private DealsPage dealspage;

    @BeforeClass
    private void setup() {
        driver = DriverSetup.setDriver();
        dealspage = new DealsPage(driver);
    }


    @Test
    public void CheckBaggage() throws InterruptedException {
        dealspage.openPage();
        dealspage.clickBaggage();
        Thread.sleep(3000);
        WebElement header = driver.findElement(By.xpath(dealspage.getHeaderXPATH()));
        Thread.sleep(1000);
        System.out.println(header.getText());
        Assert.assertEquals(header.getText(), "Baggage Service in Italy");
    }

    @Test
    public void CheckPrivateGuides() throws InterruptedException {
        dealspage.openPage();
        dealspage.clickPrivateGuides();
        Thread.sleep(3000);
        WebElement header = driver.findElement(By.xpath(dealspage.getHeaderXPATH()));
        Thread.sleep(1000);
        System.out.println(header.getText());
        Assert.assertEquals(header.getText(), "Private Guides in Italy");
    }

    @Test
    public void CheckItaliaPassProgram() throws InterruptedException {
        dealspage.openPage();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(1000);
        dealspage.clickItaliaPass();
        Thread.sleep(3000);
        WebElement header = driver.findElement(By.xpath(dealspage.getHeaderXPATH()));
        Thread.sleep(1000);
        System.out.println(header.getText());
        Assert.assertEquals(header.getText(), "ItaliaPass Program");
    }

    @AfterClass
    public void tearDown () {
        DriverSetup.closeDriver();
    }
}
