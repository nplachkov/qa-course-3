package POMTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends AddToCartTest{
    @BeforeMethod
    public void addToCart(){
        super.addToCart();
    }

    @Test
    public void checkout(){
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = cartPage.cartContinue();

        CheckoutPage2 checkoutPage2 = checkoutPage.checkoutContinue();
        CheckoutFinalPage checkoutFinalPage = checkoutPage2.finish();

        Assert.assertTrue(checkoutFinalPage.isAt());

    }
}