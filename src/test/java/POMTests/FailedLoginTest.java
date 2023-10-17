package POMTests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FailedLoginTest extends TestUtil {
    @Test(dataProvider = "wrongUsersFromCSV")
    public void unSuccessfulLoginFromCSV(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        Assert.assertTrue(loginPage.isAt());
    }
}