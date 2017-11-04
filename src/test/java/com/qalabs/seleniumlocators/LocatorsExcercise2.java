package com.qalabs.seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsExcercise2 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://www.google.com.mx/");
        driver.findElement(By.id("Invalid_Id"));
        driver.quit();

    }
}
