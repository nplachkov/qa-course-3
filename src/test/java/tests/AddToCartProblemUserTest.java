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
        int afterItem1 = productPage.getItemsInCart();

        productPage.addItemToCart("bike-light");
        int afterItem2 = productPage.getItemsInCart();

        productPage.addItemToCart("bolt-t-shirt");
        int afterItem3 = productPage.getItemsInCart();

        //A simple if statement, to understand which item was not added successfully - if any.
        if (afterItem1 > 0){
            System.out.println("Successfully added item 1.");
            if (afterItem2 == afterItem1+1){
                System.out.println("Successfully added item 2.");
                if (afterItem3 == afterItem2+1){
                    System.out.println("Successfully added item 3.");
                }
                else {
                    System.out.println("Item 3 was not added.");
                }
            }
            else {
                System.out.println("Item 2 was not added.");
            }
        }
        else {
            System.out.println("Item 1 was not added.");
        }

        Assert.assertEquals(productPage.getItemsInCart(),3,"Amount of items added to cart.");
    }
}