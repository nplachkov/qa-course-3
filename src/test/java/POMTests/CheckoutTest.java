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

    @Test (dataProvider = "checkoutDetailsFromCSV")
    public void checkout(String firstName, String lastName, String postCode){
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = cartPage.cartContinue();

        CheckoutPage2 checkoutPage2 = checkoutPage.checkoutContinue(firstName, lastName, postCode);
        CheckoutFinalPage checkoutFinalPage = checkoutPage2.finish();

        Assert.assertTrue(checkoutFinalPage.isAt());

    }
}