package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxTest {
    WebDriver driver;
    String url = "https://demoqa.com/checkbox";

    @BeforeTest
        public void setUp(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
    }

    @Test
    public void testCheckbox() {
//        WebElement checkBoxHome = driver.findElement(By.xpath("//div[@id='tree-node']/ol/li//span[@class='rct-title']"));
//        checkBoxHome.click();

        WebElement expendButton = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/div/button[1]"));
        expendButton.click();

        WebElement officeButton = driver.findElement(By.xpath("//div[@id='tree-node']/ol/li/ol/li[2]/ol/li[2]/span[@class='rct-text']/label/span[@class='rct-title']"));
        officeButton.click();


        WebElement collapsButton = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/div/button[2]"));
        collapsButton.click();

        WebElement resultMessage = driver.findElement(By.xpath("//*[@id=\"result\"]"));
        String expectedResult = "You have selected :\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general";

        System.out.println(resultMessage.getText());

        Assert.assertTrue(resultMessage.getText().contains(expectedResult));
        Assert.assertEquals(resultMessage.getText(), expectedResult);
    }



        @AfterTest
        public void tearDown(){
            driver.close();
        }


    }



