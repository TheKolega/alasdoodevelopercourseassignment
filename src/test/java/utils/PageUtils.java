package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class PageUtils {

    private WebDriver driver;

    /**
     * Waits until element is visible, and then clickable.
     *
     * @param driver  in which the page is loaded.
     * @param element which we check for.
     * @return PageUtils instance if all is well, throws Error if element not visible, throws Error if element not clickable.
     */
    public static PageUtils isLoaded(WebDriver driver, WebElement element) {
        PageUtils pageUtils = new PageUtils();
        pageUtils.waitUntilElementIsVisible(driver, element).waitUntilElementIsClickable(driver, element);
        return pageUtils;
    }

    public PageUtils waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        try {
            this.driver = driver;
            waitUntilCondition(ExpectedConditions.visibilityOf(element), "Element: " + element + " not visible.");
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element is not visible");
        }
    }

    public PageUtils waitUntilElementIsClickable(WebDriver driver, WebElement element) {
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

    /* Show cursor on web page
     *
     */
    public static void enableCursorViaJS(WebDriver driver) throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        File file = new File("src/test/java/utils/enableCursor.js");
        String fileContents = Files.readString(file.toPath(), StandardCharsets.UTF_8);
        js.executeScript(fileContents);
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void tryToClick(WebDriver driver, WebElement targetElement) {
        Actions action = new Actions(driver);
        boolean tryingToClick = true;
        while (tryingToClick) {
            try {
                targetElement.click();
                tryingToClick = false;
            } catch (ElementClickInterceptedException e) {
                PageUtils.scrollIntoView(driver, targetElement);
            }
        }
    }

}
