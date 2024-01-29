package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLogin {
    @Parameters({"usernameP", "passwordP","errorP"})
    @Test(priority = 2, groups = {"smoke","all"})
    public void loginWithInvalidUser(String username, String password, String error){
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url); // deschide url ul dat
        driver.manage().window().maximize(); // face ecranul fullscreen

        WebElement usernameInput = driver.findElement(By.xpath("//input[@type='text']"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("flash"));
        String invalidUserMessageContent = error;
        Assert.assertTrue(errorMessage.getText().contains(invalidUserMessageContent));

        driver.close();
    }

//    @Test(priority=1, groups = {"smoke"})
//    public void loginWithInvalidPassword(){
//        WebDriver driver = new ChromeDriver();
//        String url = "https://the-internet.herokuapp.com/login";
//        driver.get(url); // deschide url ul dat
//        driver.manage().window().maximize(); // face ecranul fullscreen
//
//        WebElement usernameInput = driver.findElement(By.xpath("//input[@type='text']"));
//        usernameInput.sendKeys("tomsmith");
//
//        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
//        passwordInput.sendKeys("wrongPassword");
//
//        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
//        loginButton.click();
//
//        WebElement errorMessage = driver.findElement(By.id("flash"));
//        String invalidPasswordMessageContent = "Your password is invalid!";
//        Assert.assertTrue(errorMessage.getText().contains(invalidPasswordMessageContent));
//
//        driver.close();
//    }
}
