package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;


public class Task14 extends TestBase {

    @Test
    public void task14 () {
        WebDriverWait w = new WebDriverWait(driver, 10);

        logIn();
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=countries&doc=edit_country']")).click();
        List<WebElement> icons = driver.findElements(By.cssSelector("i[class='fa fa-external-link']"));
        String windowHandle = driver.getWindowHandle();
        for (WebElement c : icons) {
            c.click();
            w.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> windows = driver.getWindowHandles();
            windows.remove(windowHandle);
            String newWindow = windows.iterator().next();
            driver.switchTo().window(newWindow);
            w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
            driver.close();
            driver.switchTo().window(windowHandle);
        }

    }

    public void logIn() {
        String admin = "admin" ;
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys(admin);
        driver.findElement(By.name("password")).sendKeys(admin);
        driver.findElement(By.name("login")).click();
    }
}
