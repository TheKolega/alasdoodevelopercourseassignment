package localhost.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.Map;

public class PageObject<T extends LoadableComponent<T>> extends LoadableComponent<T> {

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
