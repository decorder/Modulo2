package com.qalabs.seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class LocatorsExcercise5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx/");
        WebElement dropdown= driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);

        System.out.println("Available Options: "+ select.getOptions());

        System.out.println("Is Multiple: "+ select.isMultiple());
        System.out.println("First option: "+ select.getFirstSelectedOption().getText());

        select.selectByIndex(5);
        System.out.println("Selected Option: " + select.getFirstSelectedOption().getText());
        Thread.sleep(2000);

        select.selectByValue("search-alias=automotive");
        System.out.println("Selected Option 2: "+ select.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        driver.quit();
    }
}
