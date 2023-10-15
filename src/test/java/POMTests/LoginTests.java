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

//    Login tests that use the provided username/password combination from the specified CSV file using DataProvider.
    @Test (dataProvider = "validUsersFromCSV")
    public void successfulLoginFromCSV(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login(username, password);

        Assert.assertTrue(productPage.isAt());
    }

    @Test (dataProvider = "wrongUsersFromCSV")
    public void unSuccessfulLoginFromCSV(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        Assert.assertTrue(loginPage.isAt());
    }
}