package SauceDemo.Tests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedLogin extends TestUtil {

    @Test
    private void failedLogin(){
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("wrongpassword");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("error-button"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }
}