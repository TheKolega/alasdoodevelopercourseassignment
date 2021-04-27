package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class TeacherPage extends PageObject {

    private final String pageLoadedText = "";
    private final String pageUrl = "/teacher";
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = ".MuiButtonBase-root:nth-child(1) .MuiTypography-root")
    @CacheLookup
    private WebElement students;

    @FindBy(css = ".MuiButtonBase-root:nth-child(2) .MuiTypography-root")
    @CacheLookup
    private WebElement teachers;

    @FindBy(css = ".MuiButtonBase-root:nth-child(3) .MuiTypography-root")
    @CacheLookup
    private WebElement courses;

    @FindBy(css = ".MuiButtonBase-root:nth-child(4) .MuiTypography-root")
    @CacheLookup
    private WebElement settings;

    @FindBy(css = ".MuiFab-root")
    @CacheLookup
    private WebElement addButton;

    @FindBy(css = ".MuiDataGrid-row:nth-child(1) > .MuiDataGrid-cell:nth-child(1)")
    @CacheLookup
    private WebElement entryFirst;


    @FindBy(css = "button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedSecondary")
    @CacheLookup
    private WebElement delete;

    @FindBy(id = "formik-text-field-142")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "formik-text-field-138")
    @CacheLookup
    private WebElement name;

    @FindBy(css = "button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary")
    @CacheLookup
    private WebElement save;


    @FindBy(id = "formik-text-field-140")
    @CacheLookup
    private WebElement surname;


    @FindBy(css = "button.MuiButtonBase-root.MuiButton-root.MuiButton-text")
    @CacheLookup
    private WebElement toggleCourses;

    public TeacherPage(WebDriver driver) {
        super(driver);
        assertTrue(teachers.isDisplayed());
    }

    public boolean isInitialized() {
        return teachers.isDisplayed();
    }

    /**
     * Click on Add Button
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage clickAddButton() {
        addButton.click();
        return this;
    }

    /**
     * Click on the first entry in the table.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage clickEntryFirst() {
        entryFirst.click();
        return this;
    }

    /**
     * Click on Courses Link.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage clickCoursesLink() {
        courses.click();
        return this;
    }

    /**
     * Click on Delete Button.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage clickDeleteButton() {
        delete.click();
        return this;
    }

    /**
     * Click on Save Button.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage clickSaveButton() {
        save.click();
        return this;
    }

    /**
     * Click on Settings Link.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage clickSettingsLink() {
        settings.click();
        return this;
    }

    /**
     * Click on Students Link.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage clickStudentsLink() {
        students.click();
        return this;
    }

    /**
     * Click on Teachers Link.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage clickTeachersLink() {
        teachers.click();
        return this;
    }

    /**
     * Click on Toggle Courses Button.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage clickToggleCoursesButton() {
        toggleCourses.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage fill() {
        setNameTextField();
        setSurnameTextField();
        setEmailEmailField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Email Email field.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage setEmailEmailField() {
        return setEmailEmailField(data.get("EMAIL"));
    }

    /**
     * Set value to Email Email field.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage setEmailEmailField(String emailValue) {
        email.sendKeys(emailValue);
        return this;
    }

    /**
     * Set default value to Name Text field.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage setNameTextField() {
        return setNameTextField(data.get("NAME"));
    }

    /**
     * Set value to Name Text field.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage setNameTextField(String nameValue) {
        name.sendKeys(nameValue);
        return this;
    }

    /**
     * Set default value to Surname Text field.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage setSurnameTextField() {
        return setSurnameTextField(data.get("SURNAME"));
    }

    /**
     * Set value to Surname Text field.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage setSurnameTextField(String surnameValue) {
        surname.sendKeys(surnameValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage submit() {
        clickSaveButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

}
