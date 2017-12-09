package com.nickkbright.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By fromInput = By.name("faresearch_route-origin");
    By toInput = By.name("faresearch_route-destination");
    By calendarInput = By.name("faresearch_route-departure_date");
    By dateInput = By.linkText("12");
    By submitBtn = By.id("submit");
    By searchInput = By.id("edit-keys");

    public HomePage (WebDriver driver) {
        this.driver = driver;
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
    public void ticketSubmit() {
        driver.findElement(submitBtn).submit();
    }
    public void sendSearchInput() {
        driver.findElement(searchInput).sendKeys("Milan");
    }
    public void searchSubmit() {
        driver.findElement(searchInput).submit();
    }
}
