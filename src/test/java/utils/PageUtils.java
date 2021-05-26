package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {

    private WebDriver driver;

    public static PageUtils isLoaded() {
        PageUtils pageUtils = new PageUtils();
        return pageUtils;
    }

    public PageUtils waitForElementIsVisible(WebDriver driver, WebElement element) {
        try {
            this.driver = driver;
            waitUntilCondition(ExpectedConditions.visibilityOf(element), "Element: " + element + " not visible.");
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element is not visible");
        }
    }

    public PageUtils waitForElementIsClickable(WebDriver driver, WebElement element) {
        try {
            waitUntilCondition(ExpectedConditions.elementToBeClickable(element), "Element: " + element + " not clickable.");
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element is not clickable");
        }
    }

    private <T> T waitUntilCondition(ExpectedCondition<T> condition, String message) {
        int count = 0;
        while (count < 12) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, ConstEnum.BASIC_WAIT_TIME_IN_SECONDS.getValue() / 12);
                return wait.until(condition);
            } catch (StaleElementReferenceException e) {
                // e.toString();
                //LOGGER.debug("Trying to recover from a stale element reference exception");
                count = count + 1;
            } catch (TimeoutException e) {
                count = count + 1;
            }
        }
        throw new AssertionError(message + ": " + condition);
    }

}
