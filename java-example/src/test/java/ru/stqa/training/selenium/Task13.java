package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Task13 extends TestBase {


    @Test
    public void task13 () {

        WebDriverWait w = new WebDriverWait(driver, 10);

        driver.navigate().to("http://litecart.stqa.ru/en/");
        List<WebElement> products;
        for(int i = 0; i < 3; i++) {
            products = driver.findElements(By.cssSelector("div#box-latest-products li"));
            products.get(i).click();
            if(isElementPresent(driver, By.cssSelector("td.options select"))) {
                Select options = new Select(driver.findElement(By.cssSelector("select[name*=options]")));
                options.selectByIndex(1);
            }
            driver.findElement(By.name("add_cart_product")).click();
            w.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div#cart span.quantity"),
                    Integer.valueOf(i + 1).toString()));

            driver.navigate().back();
        }

        driver.findElement(By.cssSelector("a[href='http://litecart.stqa.ru/en/checkout']")).click();

        for(int i = 0; i < 3; i++) {
            WebElement tableElement = driver.findElement(By.cssSelector("table.dataTable.rounded-corners")) ;
            driver.findElement(By.name("remove_cart_item")).click();
            w.until(ExpectedConditions.stalenessOf(tableElement));
        }
        w.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("em"), "There are no items in your cart."));


    }

    public  boolean isElementPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
