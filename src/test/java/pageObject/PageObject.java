package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
    public PageObject() {
    }

    public pageObject.PageObject(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public pageObject.PageObject(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public pageObject.PageObject(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }
    */

}
