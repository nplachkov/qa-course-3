package POMTests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends TestUtil {
    @BeforeMethod
    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.login("standard_user","secret_sauce");
        productPage.addToCart();
    }
    @Test (dataProvider = "checkoutDetailsFromCSV")
    public void checkout(String firstName, String lastName, String postCode){
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = cartPage.cartContinue();

        CheckoutPage2 checkoutPage2 = checkoutPage.checkoutContinue(firstName, lastName, postCode);
        CheckoutFinalPage checkoutFinalPage = checkoutPage2.finish();

        Assert.assertTrue(checkoutFinalPage.isAt());

    }
}