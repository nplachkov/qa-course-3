package tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class AddToCartProblemUserTest extends TestUtil {
    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(problemUsername,correctPassword);
    }

    @Test
    public void addToCartProblemUser(){
        ProductPage productPage = new ProductPage(driver);

        productPage.addItemToCart("backpack");
        productPage.addItemToCart("bike-light");
        productPage.addItemToCart("bolt-t-shirt");

        Assert.assertEquals(productPage.getItemsInCart(),3,"Amount of items added to cart.");
    }
}