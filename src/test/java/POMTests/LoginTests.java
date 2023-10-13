package POMTests;

import base.TestUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import java.time.Duration;

public class LoginTests extends TestUtil {

    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productPage.isAt());


    }

    @Test
    public void unSuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauceWRONG");

        Assert.assertTrue(loginPage.isAt());
    }
}