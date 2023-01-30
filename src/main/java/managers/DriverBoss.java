package managers;

import helpers.Directory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverBoss {

    public static WebDriver driver;

    public static WebDriver getInstance(){
        if (driver == null) {
            driver = setUpWebDriver();
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver !=null) {
            driver.quit();
            driver = null;
        }
    }

    private static WebDriver setUpWebDriver(){
        System.setProperty("webdriver.chrome.driver", Directory.DRIVER_DIR + "\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
}
