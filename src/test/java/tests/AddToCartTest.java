package tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class AddToCartTest extends TestUtil {
    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(correctUsername,correctPassword);
    }

    @Test
    public void addToCart(){
        ProductPage productPage = new ProductPage(driver);

        productPage.addItemToCart("backpack");
        productPage.addItemToCart("bike-light");

        Assert.assertEquals(productPage.getItemsInCart(),2,"Items added to cart.");
    }
}