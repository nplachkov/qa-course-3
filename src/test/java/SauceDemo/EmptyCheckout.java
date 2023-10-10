package SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmptyCheckout extends SuccessfulLogin{
    @BeforeMethod
    public void successfulLogin() {
        super.successfulLogin();
    }

    @Test
    public void emptyCheckout(){
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

        String checkoutExpectedURL = "https://www.saucedemo.com/checkout-complete.html";
        String currentURL = driver.getCurrentUrl();
        String checkoutResult;
        String resultText = "Checkout test: ";

        if (!currentURL.equals(checkoutExpectedURL)) {
            checkoutResult = "PASS";
            System.out.println(resultText + checkoutResult);
        } else {
            checkoutResult = "FAIL";
            System.out.println(resultText + checkoutResult);
            Assert.fail();
        }
    }
}