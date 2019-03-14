package ru.stqa.training.selenium;


import org.junit.Test;
import org.openqa.selenium.By;
import java.util.UUID;

public class Task12_1 extends TestBase {

    @Test
    public void task12() {

        String logPass = "admin";
        String userDir = System.getProperty("user.dir");
        String name = UUID.randomUUID().toString() + " duck";
        System.out.println(name);


        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driver.findElement(By.name("username")).sendKeys(logPass);
        driver.findElement(By.name("password")).sendKeys(logPass);
        driver.findElement(By.name("login")).click();

        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product']")).click();

        //General
        driver.findElement(By.xpath("//label[1]/input[@name='status']")).click();
        driver.findElement(By.name("name[en]")).sendKeys(name);
        driver.findElement(By.name("code")).sendKeys("2311");
        driver.findElement(By.name("new_images[]")).sendKeys(userDir + "\\src\\test\\java\\ru\\stqa\\training\\selenium\\duck.jpg");
        driver.findElement(By.name("date_valid_from")).sendKeys("13032019");
        driver.findElement(By.name("date_valid_to")).sendKeys("13052019");

        //Information
        driver.findElement(By.cssSelector("a[href='#tab-information']")).click();
        driver.findElement(By.cssSelector("select[name='manufacturer_id']")).click();
        driver.findElement(By.cssSelector("[name='manufacturer_id'] option[value='1']")).click();
        driver.findElement(By.name("keywords")).sendKeys("test_keywords");
        driver.findElement(By.name("short_description[en]")).sendKeys("test_shortDesc");
        driver.findElement(By.cssSelector("div[class='trumbowyg-editor']")).sendKeys("test");
        driver.findElement(By.name("head_title[en]")).sendKeys("test_Title");
        driver.findElement(By.name("meta_description[en]")).sendKeys("test_Meta");

        //Prices
        driver.findElement(By.cssSelector("a[href='#tab-prices']")).click();
        driver.findElement(By.name("purchase_price")).sendKeys("1");
        driver.findElement(By.cssSelector("select[name='purchase_price_currency_code']")).click();
        driver.findElement(By.cssSelector("option[value='USD']")).click();
        driver.findElement(By.name("prices[USD]")).sendKeys("10");

        //Save
        driver.findElement(By.name("save")).click();

        //Check
        driver.findElement(By.linkText(name)).click();
        System.out.println(name);
    }

}
