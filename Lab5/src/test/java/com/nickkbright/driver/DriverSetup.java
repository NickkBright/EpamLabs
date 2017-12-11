package com.nickkbright.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public abstract class DriverSetup {

    private final static String CHROME_DRIVER = "webdriver.chrome.driver";

    private final static String CHROME_DRIVER_PATH = "chromedriver"+ File.separator+"chromedriver.exe";

    private static WebDriver driver;
    private DriverSetup(){};


    public static WebDriver setDriver() {
        if(driver == null){
            System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
