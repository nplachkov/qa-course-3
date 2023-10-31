package pages;

import base.TestUtil;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends TestUtil {
    //The Base Page extends the TestUtil, hence it sets the relevant WebDriver from the method in TestUtil.
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    //Introduces the isAt() method that is implemented in all the other pages that extend this BasePage.
    public abstract boolean isAt();
}