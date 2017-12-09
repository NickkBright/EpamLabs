package com.nickkbright.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public abstract class DriverSetup {
    private static WebDriver driver;
    private DriverSetup(){};


    public static WebDriver setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
