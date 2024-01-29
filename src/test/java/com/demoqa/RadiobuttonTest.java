package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadiobuttonTest {
    WebDriver driver;



    @BeforeTest
    public void setUp() {
        String url = "https://demoqa.com/radio-button";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement consentButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]"));
        consentButton.click();

    }

    @Test
    public void radioButtonYes() {

        WebElement yesButton = driver.findElement(By.xpath("//div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']/div[2]/div[2]/div[2]/label[@class='custom-control-label']"));
        yesButton.click();

        WebElement resultYesMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p"));
        String expectedResult = "You have selected Yes";
        Assert.assertTrue(resultYesMessage.getText().contains(expectedResult));
        Assert.assertEquals(expectedResult, resultYesMessage.getText());
    }


    @Test
    public void radioButtonImpressive() {

        WebElement impressiveButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label"));
        impressiveButton.click();

        WebElement resultImpressiveMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p"));
        String expectedResult2 = "You have selected Impressive";
        Assert.assertTrue(resultImpressiveMessage.getText().contains(expectedResult2));
        Assert.assertEquals(expectedResult2, resultImpressiveMessage.getText());
    }

        @AfterTest
        public void tearDown () {
            driver.close();
        }


    }


