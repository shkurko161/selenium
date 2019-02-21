package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckSticker extends TestBase{

    @Test
    public void checkSticker() {
        driver.navigate().to("http://localhost/litecart");
        List<WebElement>  products = driver.findElements(By.cssSelector(".product"));
        for (int i = 0; i < products.size(); i++) {
            List<WebElement> stikers = products.get(i).findElements(By.cssSelector("[class^=sticker]"));
            if (stikers.isEmpty()) {
                System.out.println("У одного из товаров отсутствует стикер");
            } else if (stikers.size() > 1) {
                System.out.println("У одного из товаров несколько стикеров");
            }


        }

    }
}
