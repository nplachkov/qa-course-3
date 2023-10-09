package SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ResetAppState extends SuccessfulLogin {

    @BeforeMethod
    public void successfulLogin() {
        super.successfulLogin();
    }

    @Test
    public void ResetAppState() {
        WebElement addBackpackButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addBackpackButton.click();

        WebElement addBikeLightButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addBikeLightButton.click();

        WebElement burgerMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenuButton.click();

        WebElement ResetSideBarButton = driver.findElement(By.id("reset_sidebar_link"));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.id("reset_sidebar_link"))).click();

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