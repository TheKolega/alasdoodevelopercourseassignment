package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class SettingsPage extends PageObject {

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

    public SettingsPage() {
        super();
    }

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public SettingsPage(WebDriver driver, Map<String, String> data) {
        super(driver, data);
    }

    public SettingsPage(WebDriver driver, Map<String, String> data, int timeout) {
        super(driver, data, timeout);
    }

    public boolean isInitialized() {
        return settings.isDisplayed();
    }

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
