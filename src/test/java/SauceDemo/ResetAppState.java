package SauceDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v115.network.model.TrustTokenOperationDone;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class ResetAppState {
    public WebDriver driver;

    @BeforeMethod
    private void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    private void tearDown(){
        driver.quit();
    }

    @Test
    public void ResetAppState() {
        driver.get("https://www.saucedemo.com/"); //Gets the URL

        //Finds the Username field by id. Clicks on it. Clears it. Inputs the provided username
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

        WebElement addBackpackButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addBackpackButton.click();

        WebElement addBikeLightButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addBikeLightButton.click();

        WebElement burgerMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenuButton.click();

        WebElement ResetSideBarButton = driver.findElement(By.id("reset_sidebar_link"));
        new WebDriverWait(driver, Duration.ofMillis(20)).until(ExpectedConditions.elementToBeClickable(By.id("reset_sidebar_link"))).click();

        WebElement removeBackpackButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        WebElement removeBikeLightButton = driver.findElement(By.id("remove-sauce-labs-bike-light"));

        String resetAppStateButtonResult;
        if (removeBackpackButton.isDisplayed() && removeBikeLightButton.isDisplayed()){
            resetAppStateButtonResult = "PASS";
        }
        else {
            resetAppStateButtonResult = "FAIL";
            //Assert.fail();
        }
        System.out.println("Reset App State button test: " + resetAppStateButtonResult);
    }
}