package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{
    private final static String PRODUCT_BASE_ID = "add-to-cart-sauce-labs-";
    private final static String REMOVE_PRODUCT_BASE_ID = "remove-sauce-labs-";
    @FindBy (className ="title")
    WebElement pageTitle;
    @FindBy(className = "shopping_cart_link")
    WebElement cartButton;
    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public int getItemsInCart(){
        return Integer.parseInt(cartBadge.getText());
    }

    public void addItemToCart(String itemName){
        //Element locator. It combines the String PRODUCT_BASE_ID and the added item name.
        WebElement itemTobeAdded = driver.findElement(By.id(PRODUCT_BASE_ID + itemName));
        itemTobeAdded.click();
    }

    public void removeItemFromCart(String itemName){
        //Element locator. It combines the String REMOVE_PRODUCT_BASE_ID and the added item name.
        WebElement itemTobeRemoved = driver.findElement(By.id(REMOVE_PRODUCT_BASE_ID + itemName));
        itemTobeRemoved.click();
    }

    @Override
    public boolean isAt() {
        return pageTitle.isDisplayed();
    }
    public CartPage productPageContinue(){
        cartButton.click();
        return new CartPage(driver);
    }
}