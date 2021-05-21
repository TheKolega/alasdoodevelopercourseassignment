package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PageObject {

    protected WebDriver driver;
    Map<String, String> data;
    int timeout;

    public PageObject() {
    }

    public PageObject(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
