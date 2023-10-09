package SauceDemo;

import base.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Logout extends SuccessfulLogin {
    @BeforeMethod
    public void successfulLogin() {
        super.successfulLogin();
    }

    @Test
    public void Logout() {
        WebElement burgerMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenuButton.click();

        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();
        //logoutButton.click();

        String logoutExpectedURL = "https://www.saucedemo.com/";
        String logoutActualURL = driver.getCurrentUrl();
        String logoutResult;

        if (logoutActualURL.equalsIgnoreCase(logoutExpectedURL)) {
            logoutResult = "PASS";
        } else {
            logoutResult = "FAIL";
            Assert.fail();
        }
        System.out.println("Logout test: " + logoutResult);
    }
}