package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextboxTest {
    WebDriver driver;
    String url = "https://demoqa.com/text-box";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
    }

    @Test
    public void testForm() {


        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Pasca Cristina Mihaela");

        WebElement Email = driver.findElement(By.id("userEmail"));
        Email.sendKeys("crysam87@yahoo.com");

        WebElement CurrentAddress = driver.findElement(By.id("currentAddress"));
        CurrentAddress.sendKeys("Constanta");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Cluj-Napoca");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();


        WebElement result = driver.findElement(By.id("output"));
        String expectedResult = "Name:Pasca Cristina Mihaela\n" +

                "Email:crysam87@yahoo.com\n" +

                "Current Address :Constanta\n" +

                "Permananet Address :Cluj-Napoca";
        System.out.println(result.getText());
        System.out.println(expectedResult);
       Assert.assertTrue(result.getText().contains(expectedResult));
       Assert.assertEquals(expectedResult, result.getText());

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }


    public static void sleep(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
