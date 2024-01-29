package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest {
    @Test
    public void Logout(){
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url); // deschide url ul dat
        driver.manage().window().maximize(); // face ecranul fullscreen

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(("SuperSecretPassword!"));

        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

        WebElement logoutButton = driver.findElement(By.className("radius"));
        logoutButton.click();

        WebElement successMesage = driver.findElement((By.id("flash")));
        String successMessageContent = "You logged out of the secure area!";
        Assert.assertTrue(successMesage.getText().contains(successMessageContent));

        driver.close();

    }
}
