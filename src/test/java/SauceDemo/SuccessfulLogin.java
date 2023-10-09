package SauceDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.*;

public class SuccessfulLogin {
    public WebDriver driver;

    //Sets the WebDriver before running the method
    @BeforeMethod
    private void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //Quits after running the method
    @AfterMethod
    private void tearDown(){
        driver.quit();
    }

    @Test
    public void successfulLogin(){
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

        //Gets the current URL and confirms if the user logged in.
        String loginActualURL = driver.getCurrentUrl();
        String loginResult;

        String loginExpectedURL = "https://www.saucedemo.com/inventory.html";
        if (loginActualURL.equalsIgnoreCase(loginExpectedURL)){
            loginResult = "PASS";
            System.out.println("Login test: " + loginResult);
        }
        else {
            loginResult = "FAIL";
            System.out.println("Login test: " + loginResult);
            Assert.fail();
        }


        WebElement burgerMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenuButton.click();

        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        new WebDriverWait(driver, Duration.ofMillis(20)).until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();
        //logoutButton.click();

        String logoutExpectedURL = "https://www.saucedemo.com/";
        String logoutActualURL = driver.getCurrentUrl();
        String logoutResult;

        if (logoutActualURL.equalsIgnoreCase(logoutExpectedURL)){
            logoutResult = "PASS";
        }
        else {
            logoutResult = "FAIL";
            Assert.fail();
        }
        System.out.println("Logout test: " + logoutResult);
    }
}