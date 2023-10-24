package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestUtil extends DataProviders {
    public WebDriver driver;
    private String testURL, browser;
    private int implicitWait;

    //Sets up the driver and opens the Test URL. (The driver is determined by the setupDriver() method below.
    @BeforeMethod
    public void setupDriverAndOpenTestAddress(){
        readConfig("src/test/resources/config.properties");
        setupDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.get(testURL);
    }

    //Reads the config.properties file and assigns the properties from it into the Strings below.
    private void readConfig(String fullPathToConfigFile){
        try{
            FileInputStream fileInputStream = new FileInputStream(fullPathToConfigFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            testURL = properties.getProperty("URL");
            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    //Assigns the relevant browser based on the browser input from the "config.properties" file.
    private void setupDriver(){
        switch (browser){
            case "chrome":
                driver = setupChromeDriver();
                break;
            case "firefox":
                driver = setupFirefoxDriver();
                break;
            case "safari":
                driver = setupSafariDriver();
                break;
            default:
                driver = setupChromeDriver();
        }
    }

    //Chrome driver setup method.
    private WebDriver setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    //Firefox driver setup method.
    private WebDriver setupFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    //Safari driver setup method.
    private WebDriver setupSafariDriver(){
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }

    //Cleans up after completing the test. (Closes the browser)
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}