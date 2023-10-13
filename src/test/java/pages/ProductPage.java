package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    @FindBy (className ="title")
    WebElement pageTitle;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return pageTitle.isDisplayed();
    }
}