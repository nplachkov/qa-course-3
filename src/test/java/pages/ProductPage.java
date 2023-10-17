package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{
    @FindBy (className ="title")
    WebElement pageTitle;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBackpackButton;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addToCartLightButton;
    @FindBy(className = "shopping_cart_link")
    WebElement cartButton;
    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public boolean isAt() {
        return pageTitle.isDisplayed();
    }

    public CartPage addToCart(){
        addToCartBackpackButton.click();
        addToCartLightButton.click();

        if (cartBadge.isDisplayed()){
            cartButton.click();
        }
        else {
            System.out.println("Cart item badge not displayed.");
            cartButton.click();
        }

        return new CartPage(driver);
    }
}