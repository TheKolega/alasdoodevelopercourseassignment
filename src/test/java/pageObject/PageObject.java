package pageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class PageObject<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    private LoadableComponent<?> parent;
    protected WebDriver driver;
    Map<String, String> data;
    int timeout;
    private static final String baseUrl = "http://localhost:3000";

    public static String getBaseUrl() {
        return baseUrl;
    }

    @Override
    protected void load() {
        this.driver.get(getBaseUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        Assertions.assertTrue(driver.getCurrentUrl().contains(baseUrl), "Home page not loaded");
    }

    public PageObject<T> isElementIsClickable(By by) {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element is not clickable");
        }
    }

    public PageObject<T> isElementIsVisible(By by) {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element is not visible");
        }
    }

    public PageObject() {
    }

    public PageObject(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PageObject(WebDriver driver, LoadableComponent<?> parent) {
        this(driver);
        this.parent = parent;
    }

    public PageObject(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public PageObject(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

}
