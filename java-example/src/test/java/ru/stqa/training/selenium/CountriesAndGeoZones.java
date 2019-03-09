package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountriesAndGeoZones extends TestBase {

     @Test
     public void countries() {
         String LogPass = "admin";
         driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
         driver.findElement(By.name("username")).sendKeys(LogPass);
         driver.findElement(By.name("password")).sendKeys(LogPass);
         driver.findElement(By.name("login")).click();
         List<WebElement> countriesRows = driver.findElements(By.cssSelector("tr[class = 'row'] > td:nth-child(5) > a"));
         List<String> countriesTitle = new ArrayList<>();
         for (WebElement c : countriesRows) {
             countriesTitle.add(c.getText());
         }
         List<String> sorted = countriesTitle;
         Collections.sort(sorted);
         Assert.assertTrue(countriesTitle.equals(sorted));
     }

    @Test
    public void zonesByCountry() {
        String LogPass = "admin";
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys(LogPass);
        driver.findElement(By.name("password")).sendKeys(LogPass);
        driver.findElement(By.name("login")).click();
        List<WebElement> countriesRows = driver.findElements(By.cssSelector("tr[class = 'row']"));
        List<String> cCode = new ArrayList<>();
        for (WebElement c : countriesRows) {
            Integer zones = Integer.parseInt(c.findElement(By.cssSelector("td:nth-child(6)")).getAttribute("outerText"));
            String code = c.findElement(By.cssSelector("td:nth-child(4)")).getText();
            if (zones != 0) {
                cCode.add(code);
            }
        }
        for (String s : cCode) {
            driver.navigate().to(String.format("http://localhost/litecart/admin/?app=countries&doc=edit_country&country_code=%s", s));
            List<WebElement> zoneRows = driver.findElements(By.cssSelector("table#table-zones > tbody > tr"));
            List<String> zonesTitle = new ArrayList<>();
            // z = 1, чтобы исключить header
            for (int z = 1; z < zoneRows.size(); z++) {
                zonesTitle.add(zoneRows.get(z).findElement(By.cssSelector("td:nth-child(3)")).getAttribute("outerText"));
            }
            zonesTitle.remove(zonesTitle.size()-1);
            List<String> sortedZones = zonesTitle;
            Collections.sort(sortedZones);
            Assert.assertTrue(zonesTitle.equals(sortedZones));
            driver.navigate().back();
        }
    }

    @Test
    public void geoZones () {
        String LogPass = "admin";
        driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.name("username")).sendKeys(LogPass);
        driver.findElement(By.name("password")).sendKeys(LogPass);
        driver.findElement(By.name("login")).click();

    }
}

