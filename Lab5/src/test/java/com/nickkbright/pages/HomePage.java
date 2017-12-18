package com.nickkbright.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    private final String URL = "https://www.italiarail.com/";
    private final String ButtonXPATH = "/html/body/div[12]/div[3]/div/button[1]";
    private final String SelectXPATH = "//*[@id=\"currency_select\"]/option[3]";
    private final String SearchResults = "Train from Milan Malpensa Airport to Milan";
    private final String PriceID = "rome_to_florence_price";

    By fromInput = By.name("faresearch_route-origin");
    By toInput = By.name("faresearch_route-destination");
    By calendarInput = By.name("faresearch_route-departure_date");
    By dateInput = By.linkText("23");
    By submitBtn = By.id("submit");
    By searchInput = By.id("edit-keys");
    By currencyDropdown = By.id("currency_select");
    By selectCurrency = By.xpath(SelectXPATH);
    By changeCurrency = By.xpath(ButtonXPATH);

    public HomePage (WebDriver driver) {
        super(driver);
    }

    public void sendFromInput() {
        driver.findElement(fromInput).sendKeys("Rome");
    }
    public void sendToInput() {
        driver.findElement(toInput).sendKeys("Florence");
    }
    public void setDate() {
        driver.findElement(calendarInput).click();
        driver.findElement(dateInput).click();
    }
    public String getSearchMilanResults() {
        return SearchResults;
    }

    public String getPriceID() {
        return PriceID;
    }

    public void ticketSubmit() {
        driver.findElement(submitBtn).submit();
    }
    public void sendSearchInput() {
        driver.findElement(searchInput).sendKeys("Milan");
    }
    public void searchSubmit() {
        driver.findElement(searchInput).submit();
    }
    public void openCurrencyDropdown() {
        driver.findElement(currencyDropdown).click();
    }
    public void selectCurrency() {
        driver.findElement(selectCurrency).click();
    }
    public void changeCurrency() {
        driver.findElement(changeCurrency).click();
    }

    @Override
    public void openPage () {
        driver.navigate().to(URL);
    }
}
