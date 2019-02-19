package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class LocalHostMenu extends TestBase {

    @Test
    public void LiteCartMenuClick() {
        // Авторизация
        String LogPass = "admin";
        driver.navigate().to("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys(LogPass);
        driver.findElement(By.name("password")).sendKeys(LogPass);
        driver.findElement(By.name("login")).click();
        List<WebElement> mainMenu = driver.findElements(By.cssSelector("ul#box-apps-menu li#app-"));
        for (int i = 0; i < mainMenu.size(); i++) {
            mainMenu = driver.findElements(By.cssSelector("ul#box-apps-menu li#app-"));
            WebElement menuItem = mainMenu.get(i);
            menuItem.click();
            // Проверка на наличие заголовка
            if (driver.findElements(By.cssSelector("h1")).isEmpty()) {
                System.out.println("Заголовок по адресу" + driver.getCurrentUrl() + " отсутствует!");
            }
            // Проверяем наличие подменю
            if ((driver.findElements(By.cssSelector("ul.docs li")).size() > 0)) {
                List<WebElement> subMenu = driver.findElements(By.cssSelector("ul#box-apps-menu li li"));
                for (int n = 1; n < subMenu.size(); n++) {
                    subMenu = driver.findElements(By.cssSelector("ul#box-apps-menu li li"));
                    WebElement subMenuItem = subMenu.get(n);
                    subMenuItem.click();
                    // Проверка на наличие заголовка
                    if (driver.findElements(By.cssSelector("h1")).isEmpty()) {
                        System.out.println("Заголовок по адресу" + driver.getCurrentUrl() + " отсутствует!");
                    }
                }
            }
        }
    }
}