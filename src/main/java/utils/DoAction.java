package utils;

import managers.DriverBoss;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.with;

public class DoAction {

    public static void click(WebElement element){
        try {
            waitForElement(element);
            highlight(element);
            element.click();
        } catch (Exception e) {
            Assert.fail(e.getCause().getMessage());
        }
    }

    public static void selectFromDropdown(WebElement element, String text){
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    public static void waitForElement(WebElement element) {
        with()
                .pollDelay(100, TimeUnit.MICROSECONDS)
                .and()
                .pollInterval(200, TimeUnit.MICROSECONDS)
                .await()
                .ignoreExceptions()
                .until(() -> element.isDisplayed());
    }

    private static void highlight(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) DriverBoss.getInstance();
        jse.executeScript("arguments[0].style.border=\'3px ridge green\'", new Object[]{element});
    }
}
