package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverHelper {
    public static WebDriver driver;

    public static WebDriver SetBrowserDriver(String Key) {
//        String currentWebDriver = System.getProperty("browser", "");
        switch (Key) {
            case ("chrome"):
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/driver/chromedriver");
                driver = new ChromeDriver();
                System.out.println("Chrome Browser");
                break;
            case ("firefox"):
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/test/resources/driver/geckodriver");
                driver = new FirefoxDriver();
                System.out.println("Firefox Browser");

                break;
            case ("chromeHeadless"):
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/driver/chromedriver");
//                ChromeOptions chromeHeadless = new ChromeOptions();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
//                chromeHeadless.setHeadless(true);
                driver = new ChromeDriver(options);
                break;

            default:
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/driver/chromedriver");
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}

