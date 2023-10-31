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

        loginPage.login(correctUsername,correctPassword);
        productPage.addItemToCart("backpack");
        productPage.addItemToCart("bike-light");
        productPage.productPageContinue();
    }

    @Test (dataProvider = "checkoutDetailsFromCSV")
    public void checkout(String firstName, String lastName, String postCode){
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = cartPage.cartContinue();

        CheckoutPage2 checkoutPage2 = checkoutPage.checkoutContinue(firstName, lastName, postCode);
        CheckoutFinalPage checkoutFinalPage = checkoutPage2.checkoutFinish();

        Assert.assertTrue(checkoutFinalPage.isAt());
    }
}