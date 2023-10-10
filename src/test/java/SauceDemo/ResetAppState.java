package SauceDemo;

import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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

        WebElement burgerMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenuButton.click();

        WebElement ResetSideBarButton = driver.findElement(By.id("reset_sidebar_link"));
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(ResetSideBarButton)).click();

        WebElement removeBackpackButton = driver.findElement(By.id("remove-sauce-labs-backpack"));

        String resetAppStateButtonResult;
        String resultText = "Reset App State button test: ";

        if (!removeBackpackButton.isDisplayed()){
            resetAppStateButtonResult = "PASS";
            System.out.println(resultText + resetAppStateButtonResult);
        }
        else {
            resetAppStateButtonResult = "FAIL";
            System.out.println(resultText + resetAppStateButtonResult);
            Assert.fail();
        }
    }
}