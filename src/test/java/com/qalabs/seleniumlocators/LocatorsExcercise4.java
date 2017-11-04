package com.qalabs.seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsExcercise4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        WebElement Portada = driver.findElement(By.linkText("Portada"));
        System.out.println("Portada href: "+Portada.getAttribute("href"));
        int i=1;
        for(WebElement element: driver.findElements(By.partialLinkText("Página"))){
            System.out.println("Pagina "+ i + " "+element.getAttribute("href"));
            i++;
        }
        i=1;
        for(WebElement element: driver.findElements(By.tagName("button"))){
            System.out.println("Boton "+ i  + " "+element.getText());
            i++;
        }
        //driver.quit();
    }
}
