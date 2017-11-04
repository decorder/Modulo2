package com.qalabs.seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsExcercise3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://www.nasa.gov");
        WebElement Missions = driver.findElement(By.linkText("Missions"));
        System.out.println(Missions.getAttribute("href"));
        WebElement NasaTV = driver.findElement(By.linkText("NASA TV"));
        System.out.println(NasaTV.getAttribute("href"));
        WebElement mars = driver.findElement(By.partialLinkText("Mars"));
        System.out.println(mars.getAttribute("href"));
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for(WebElement element: inputs)
            System.out.println("input: " + element.getAttribute("class"));
        driver.quit();

    }
}
