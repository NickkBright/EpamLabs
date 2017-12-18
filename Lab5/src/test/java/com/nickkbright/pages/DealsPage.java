package com.nickkbright.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealsPage extends AbstractPage{
    private final String headerXPATH = "/html/body/div[1]/div[2]/h1";
    private final String URL = "https://www.italiarail.com/italiapass";
    private final String italiaPassXPATH = "//div[@class='cc_link']/a[@href='/italiapass/italiapass-program']";

    By baggageService = By.linkText("Baggage Service in Italy");
    By privateGuides = By.linkText("Private Guides in Italy");
    By ItaliaPass = By.xpath(italiaPassXPATH);



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

    public String getHeaderXPATH() {
        return headerXPATH;
    }

    @Override
    public void openPage() {
        driver.navigate().to(URL);
    }
}
