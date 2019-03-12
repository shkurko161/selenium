package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import java.util.UUID;

public class Task11 extends TestBase {

    @Test
    public void task11 () {
        String test = "test";
        String unique = UUID.randomUUID().toString();
        String email = unique + "@dat.com";

        driver.get("http://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector("a[href='http://litecart.stqa.ru/en/create_account']")).click();
        driver.findElement(By.name("firstname")).sendKeys(test);
        driver.findElement(By.name("lastname")).sendKeys(test);
        driver.findElement(By.name("address1")).sendKeys(test);
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("city")).sendKeys(test);
        driver.findElement(By.cssSelector(".select2-selection")).sendKeys("United State");
        driver.findElement(By.cssSelector("[value='US']")).click();
        driver.findElement(By.cssSelector("select[name='zone_code']")).click();
        driver.findElement(By.cssSelector("[name='zone_code'] option[value='CA']")).click();
        driver.findElement(By.name("password")).sendKeys(test);
        driver.findElement(By.name("confirmed_password")).sendKeys(test);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("1");
        driver.findElement(By.name("create_account")).click();

        driver.findElement(By.cssSelector("a[href='http://litecart.stqa.ru/en/logout']")).click();

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(test);
        driver.findElement(By.name("login")).click();

        driver.findElement(By.cssSelector("a[href='http://litecart.stqa.ru/en/logout']")).click();
        
    }
}
