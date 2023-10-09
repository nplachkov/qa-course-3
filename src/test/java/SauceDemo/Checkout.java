package SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkout extends SuccessfulLogin {
    @BeforeMethod
    public void successfulLogin() {
        super.successfulLogin();
    }

    @Test
    public void checkout() {
        //The checkout test proceeds only if the login was successful. Otherwise it stops.
        WebElement backpackAddToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        backpackAddToCartButton.click();

        WebElement bikeLightAddToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        bikeLightAddToCartButton.click();

        WebElement shoppingCartButton = driver.findElement(By.className("shopping_cart_link"));
        shoppingCartButton.click();

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys("Nikolay");

        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys("Plachkov");

        WebElement postalCodeInput = driver.findElement(By.id("postal-code"));
        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys("4023");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        String currentURL = driver.getCurrentUrl();
        String checkoutResult;
        String checkoutExpectedURL = "https://www.saucedemo.com/checkout-complete.html";
        if (currentURL.equals(checkoutExpectedURL)) {
            checkoutResult = "PASS";
        } else {
            checkoutResult = "FAIL";
            Assert.fail("Checkout failed.");
        }
        System.out.println("Checkout test: " + checkoutResult);
    }
}