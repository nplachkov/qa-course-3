package SauceDemo.Initial;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class SuccessfulLogin extends TestUtil {
    @Test
    public void successfulLogin(){
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
        String loginExpectedURL = "https://www.saucedemo.com/inventory.html";

        String loginResult;
        String resultText = "Login test: ";

        if (loginActualURL.equalsIgnoreCase(loginExpectedURL)){
            loginResult = "PASS";
            System.out.println(resultText + loginResult);
        }
        else {
            loginResult = "FAIL";
            System.out.println(resultText + loginResult);
            Assert.fail();
        }
    }
}