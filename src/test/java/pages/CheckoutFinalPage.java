package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFinalPage extends BasePage{
    @FindBy(className = "complete-header")
    WebElement completeHeader;


    public CheckoutFinalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public boolean isAt() {
        return completeHeader.isDisplayed();
    }



}
