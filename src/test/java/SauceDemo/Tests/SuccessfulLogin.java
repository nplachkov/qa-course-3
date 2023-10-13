package SauceDemo.Tests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulLogin extends TestUtil {

    @Test
    public void successfulLogin(){
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("standard_user");

        //Finds the Password field by id. Clicks on it. Clears it. Inputs the provided password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        //Finds the Login button by id. Clicks on it.
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement shoppingCartButton = driver.findElement(By.className("shopping_cart_link"));
        Assert.assertTrue(shoppingCartButton.isDisplayed());
    }
}