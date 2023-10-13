package SauceDemo.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLInputElement;

public class Checkout extends SuccessfulLogin {
    @BeforeMethod
    public void successfulLogin() {
        super.successfulLogin();
    }


}
