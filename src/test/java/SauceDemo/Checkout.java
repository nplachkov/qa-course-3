package SauceDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkout {
    public WebDriver driver;

    //Sets the WebDriver before running the method
    @BeforeMethod
    private void setupChromDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //Quits after running the method
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkout(){
        //LOGIN STARTS
        driver.get("https://www.saucedemo.com/");

        //Finds the Username field by id. Clicks on it. Clears it. Inputs the provided username
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys("standard_user");

        //Finds the Password field by id. Clicks on it. Clears it. Inputs the provided password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        //Finds the Login button by id. Clicks on it.
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //Gets the current URL and confirms if the user logged in.
        String afterLoginURL = driver.getCurrentUrl();
        String loginResult;
        String loginExpectedURL = "https://www.saucedemo.com/inventory.html";
        if (afterLoginURL.equalsIgnoreCase(loginExpectedURL)){
            loginResult = "PASS";
        } else loginResult = "FAIL";
        System.out.println("Login test: " + loginResult);
        //LOGIN ENDS

        //The checkout test proceeds only if the login was successful. Otherwise it stops.
        if (loginResult.equals("PASS")){
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
            if (currentURL.equals(checkoutExpectedURL)){
                checkoutResult = "PASS";
            } else {
                checkoutResult ="FAIL";
                Assert.fail("Checkout failed.");
            }
            System.out.println("Checkout test: " + checkoutResult);
        } else {
            Assert.fail("Login failed. Can't proceed with chekout test.");
        }
    }
}