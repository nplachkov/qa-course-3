package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage2 extends BasePage {
    @FindBy(id = "finish")
    WebElement finishButton;

    public CheckoutPage2(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public boolean isAt() {
        return finishButton.isDisplayed();
    }

    public CheckoutFinalPage checkoutFinish(){
        finishButton.click();

        return new CheckoutFinalPage(driver);
    }
}