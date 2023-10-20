package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

    @FindBy(className = "title")
    WebElement cartPageTitle;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public boolean isAt() {
        return checkoutButton.isDisplayed();
    }

    public CheckoutPage cartContinue(){
        checkoutButton.click();

        return new CheckoutPage(driver);
    }
}