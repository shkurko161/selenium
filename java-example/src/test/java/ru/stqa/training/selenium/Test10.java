package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test10 extends TestBase {

    @Test
    public void test10 () {
        driver.navigate().to("http://localhost/litecart/en/");
        //Главная страница
        WebElement main = driver.findElement(By.cssSelector("div[id='box-campaigns'] > div > ul > li:nth-child(1)"));
        String mainTitle = main.findElement(By.cssSelector("div[class=name]")).getText();
        String mainPrice = main.findElement(By.cssSelector("s[class='regular-price']")).getText();
        String mainSellPrice = main.findElement(By.cssSelector("strong[class='campaign-price']")).getText();

        String[] mainPriceColor = main.findElement(By.cssSelector("s[class='regular-price']")).getCssValue("color").replaceAll("[^-?0-9]+", " ").split(" ");
        String mainPriceLineTrough = main.findElement(By.cssSelector("s[class='regular-price']")).getCssValue("text-decoration-line");
        Assert.assertTrue(mainPriceColor[1].equals(mainPriceColor[2]) && mainPriceColor[2].equals(mainPriceColor[3]));
        Assert.assertTrue(mainPriceLineTrough.equals("line-through"));

        String[] mainSellPriceColor = main.findElement(By.cssSelector("strong[class='campaign-price']")).getCssValue("color").replaceAll("[^-?0-9]+", " ").split(" ");
        Float mainSellPriceBold = Float.parseFloat(main.findElement(By.cssSelector("strong[class='campaign-price']")).getCssValue("font-weight"));
        Assert.assertTrue(mainSellPriceColor[2].equals("0") && mainSellPriceColor[3].equals("0"));
        //не смог понять, почему в переменную возвращается число вместо bold, поэтому переделал переменную во float и такую проверку ниже
        Assert.assertTrue(mainSellPriceBold >= 700);

        Float mainSizePrice = Float.parseFloat(driver.findElement(By.cssSelector("s[class='regular-price']")).getCssValue("font-size").replaceAll("[^-?.0-9]+",""));
        Float mainSizeSellPrice = Float.parseFloat(driver.findElement(By.cssSelector("strong[class='campaign-price']")).getCssValue("font-size").replaceAll("[^-?.0-9]+",""));
        Assert.assertTrue(mainSizePrice < mainSizeSellPrice);

        //Страница продукта
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/en/rubber-ducks-c-1/subcategory-c-2/yellow-duck-p-1']")).click();
        String title = driver.findElement(By.cssSelector("h1[class='title']")).getText();
        String price = driver.findElement(By.cssSelector("s[class='regular-price']")).getText();
        String sellPrice = driver.findElement(By.cssSelector("strong[class='campaign-price']")).getText();
        Assert.assertTrue(mainTitle.equals(title));
        Assert.assertTrue(mainPrice.equals(price));
        Assert.assertTrue(mainSellPrice.equals(sellPrice));

        String[] priceColor = driver.findElement(By.cssSelector("s[class='regular-price']")).getCssValue("color").replaceAll("[^-?0-9]+", " ").split(" ");
        String priceLineTrough = driver.findElement(By.cssSelector("s[class='regular-price']")).getCssValue("text-decoration-line");
        Assert.assertTrue(priceColor[1].equals(priceColor[2]) && priceColor[2].equals(priceColor[3]));
        Assert.assertTrue(priceLineTrough.equals("line-through"));

        String[] sellPriceColor = driver.findElement(By.cssSelector("strong[class='campaign-price']")).getCssValue("color").replaceAll("[^-?0-9]+", " ").split(" ");
        Float sellPriceBold = Float.parseFloat(driver.findElement(By.cssSelector("strong[class='campaign-price']")).getCssValue("font-weight"));
        Assert.assertTrue(sellPriceColor[2].equals("0") && sellPriceColor[3].equals("0"));
        //не смог понять, почему в переменную возвращается число вместо bold, поэтому переделал переменную во float и такую проверку ниже
        Assert.assertTrue(sellPriceBold >= 700);

        Float sizePrice = Float.parseFloat(driver.findElement(By.cssSelector("s[class='regular-price']")).getCssValue("font-size").replaceAll("[^-?.0-9]+",""));
        Float sizeSellPrice = Float.parseFloat(driver.findElement(By.cssSelector("strong[class='campaign-price']")).getCssValue("font-size").replaceAll("[^-?.0-9]+",""));
        Assert.assertTrue(sizePrice < sizeSellPrice);

    }
}
