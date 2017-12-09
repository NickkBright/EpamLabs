package com.nickkbright.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealsPage extends AbstractPage{
    private final String URL = "https://www.italiarail.com/italiapass";
    private final String XPATH = "/html/body/div[1]/div[2]/div/section/div/article/div/div/div[2]/div/div[2]/div[1]/div/div/div/a";

    By baggageService = By.linkText("Baggage Service in Italy");
    By privateGuides = By.linkText("Private Guides in Italy");
    By ItaliaPass = By.xpath(XPATH);



    public DealsPage (WebDriver driver) {
        super(driver);
    }

    public void clickBaggage () {
        driver.findElement(baggageService).click();
    }

    public void clickPrivateGuides () {
        driver.findElement(privateGuides).click();
    }

    public void clickItaliaPass () {
        driver.findElement(ItaliaPass).click();
    }

    @Override
    public void openPage() {
        driver.navigate().to(URL);
    }
}
