package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage{
    @FindBy(id = "first-name")
    WebElement firstNameInput;
    @FindBy(id = "last-name")
    WebElement lastNameInput;
    @FindBy (id = "postal-code")
    WebElement postCodeInput;
    @FindBy(id = "continue")
    WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public boolean isAt() {
        return postCodeInput.isDisplayed();
    }

    public CheckoutPage2 checkoutContinue(){
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys("Nikolay");

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys("Test");

        postCodeInput.click();
        postCodeInput.clear();
        postCodeInput.sendKeys("4000");

        continueButton.click();

        return new CheckoutPage2(driver);
    }
}
