package com.nickkbright.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TrainTravelGuidePage extends AbstractPage {
    private final String URL = "https://www.italiarail.com/italiarail-faq";

    By anchor = By.linkText("Should I purchase a rail pass or city-to-city tickets?");
    By shippingInfo = By.xpath("//*[@id=\"block-usefullinks\"]/ul/li[2]/a");
    By bicycleInfo = By.linkText("Bicycles");

    public TrainTravelGuidePage(WebDriver driver) {
        super(driver);
    }

    public void clickAnchor() {
        driver.findElement(anchor).click();
    }

    public void clickShippingInfo() {
        driver.findElement(shippingInfo).click();
    }

    public void scrollBicycleInfo() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,1000)", "");
    }

    public void clickBicycleInfo() {
        driver.findElement(bicycleInfo).click();
    }

    @Override
    public void openPage() {
        driver.navigate().to(URL);
    }
}
