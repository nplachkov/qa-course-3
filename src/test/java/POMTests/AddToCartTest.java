package POMTests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class AddToCartTest extends SuccessfulLoginTest {

    @BeforeMethod
    public void login(){
        super.successfulLogin();
    }
    @Test
    public void addToCart(){
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = productPage.addToCart();

        Assert.assertTrue(cartPage.isAt());
    }
}
