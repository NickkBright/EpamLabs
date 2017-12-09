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


public class TicketTest {
    private WebDriver driver;
    private HomePage homepage;


    @BeforeClass
    public void setup() {
        driver = DriverSetup.setDriver();
        homepage = new HomePage(driver);
    }

    @Test
    public void searchMilan() throws InterruptedException{
        driver.get("https://www.italiarail.com/");
        homepage.sendFromInput();
        Thread.sleep(1000);
        homepage.sendToInput();
        Thread.sleep(1000);
        homepage.setDate();
        homepage.ticketSubmit();
        Thread.sleep(1000);
        List<WebElement> trains = driver.findElements(By.className("soln-container"));
        Thread.sleep(1000);
        System.out.println(trains.size());

        Assert.assertNotEquals(trains.size(), 0);
    }


    @AfterClass
    public void tearDown() {
        DriverSetup.closeDriver();
    }
}
