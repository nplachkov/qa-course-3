package SauceDemo.Initial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        String resultText = "Logout test: ";
        String logoutResult;

        if (logoutActualURL.equalsIgnoreCase(logoutExpectedURL)) {
            logoutResult = "PASS";
            System.out.println(resultText + logoutResult);
        } else {
            logoutResult = "FAIL";
            System.out.println(resultText + logoutResult);
            Assert.fail();
        }
    }
}