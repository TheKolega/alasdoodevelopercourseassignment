package demoqa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.Map;

public class PageBase<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    protected LoadableComponent<?> parent;
    protected WebDriver driver;
    Map<String, String> data;
    int timeout;

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
    }

    /*
     * Constructors
     */

    public PageBase() {
    }

    public PageBase(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PageBase(WebDriver driver, LoadableComponent<?> parent) {
        this(driver);
        this.parent = parent;
    }

    public PageBase(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public PageBase(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }
}
