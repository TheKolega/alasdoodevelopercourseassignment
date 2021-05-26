package localhost.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.PageUtils;

import java.util.Map;

public class SettingsPage extends PageObject<SettingsPage> {

    private final LoadableComponent<?> parent;
    private final String pageLoadedText = "";
    private final String pageUrl = "http://localhost:3000/settings";
    private Map<String, String> data;

    public SettingsPage(WebDriver driver, LoadableComponent<?> parent) {
        super(driver);
        this.parent = parent;
    }
//
//    public SettingsPage() {
//        super();
//    }
//
//    public SettingsPage(WebDriver driver, Map<String, String> data) {
//        super(driver, data);
//    }
//
//    public SettingsPage(WebDriver driver, Map<String, String> data, int timeout) {
//        super(driver, data, timeout);
//    }

    @Override
    protected void load() {
        parent.get();
        this.driver.get(pageUrl);
    }

    @Override
    protected void isLoaded() throws Error {
//        Assertions.assertTrue(driver.getCurrentUrl().contains(pageUrl), "Settings page not loaded");
        PageUtils.isLoaded().
                waitForElementIsVisible(driver, settings).
                waitForElementIsClickable(driver, settings);
    }

    @FindBy(linkText = "Students")
    @CacheLookup
    private WebElement students;

    @FindBy(linkText = "Teachers")
    @CacheLookup
    private WebElement teachers;

    @FindBy(linkText = "Courses")
    @CacheLookup
    private WebElement courses;

    @FindBy(linkText = "Settings")
    @CacheLookup
    private WebElement settings;

    /**
     * Click on Students Link.
     *
     * @return the SettingsPage class instance.
     */
    public SettingsPage clickStudentsLink() {
        students.click();
        return this;
    }

    /**
     * Click on Teachers Link.
     *
     * @return the SettingsPage class instance.
     */
    public SettingsPage clickTeachersLink() {
        teachers.click();
        return this;
    }

    /**
     * Click on Courses Link.
     *
     * @return the SettingsPage class instance.
     */
    public SettingsPage clickCoursesLink() {
        courses.click();
        return this;
    }

    /**
     * Click on Settings Link.
     *
     * @return the SettingsPage class instance.
     */
    public SettingsPage clickSettingsLink() {
        settings.click();
        return this;
    }

}
