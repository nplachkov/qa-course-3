package POMTests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class SuccessfulLoginTest extends TestUtil {

//    Login tests that use the provided username/password combination from the specified CSV file using DataProvider.
    @Test (dataProvider = "validUsersFromCSV")
    public void successfulLoginFromCSV(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login(username, password);

        Assert.assertTrue(productPage.isAt());
    }

    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user", "secret_sauce");
    }
}