package pageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CoursePage extends PageObject<CoursePage> {

    private final String pageLoadedText = "";
    private final String pageUrl = getBaseUrl() + "/course";
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;
    //! map values to data : course name, class per week, cost per class

    public CoursePage(WebDriver driver) {
        super(driver);
    }

//    public CoursePage() {
//        super();
//    }
//
//    public CoursePage(WebDriver driver, Map<String, String> data) {
//        super(driver, data);
//    }
//
//    public CoursePage(WebDriver driver, Map<String, String> data, int timeout) {
//        super(driver, data, timeout);
//    }
//
    public boolean isInitialized() {
        return courses.isDisplayed();
    }

    @Override
    protected void load() {
        this.driver.get(pageUrl);
    }

    @Override
    protected void isLoaded() throws Error {
//        Assertions.assertTrue(driver.getCurrentUrl().contains(pageUrl), "Course page not loaded");
        Assertions.assertTrue(this.isInitialized());
    }

    //! linkText?
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

    @FindBy(css = ".MuiFab-root")
    @CacheLookup
    private WebElement addButton;

    @FindBy(css = ".MuiDataGrid-row:nth-child(1) > .MuiDataGrid-cell:nth-child(1)")
    @CacheLookup
    private WebElement entryFirst;

    @FindBy(name = "classesPerWeek")
    @CacheLookup
    private WebElement classesPerWeek;

    @FindBy(name = "costPerClass")
    @CacheLookup
    private WebElement costPerClass;

    @FindBy(name = "developerCourseName")
    @CacheLookup
    private WebElement developerCourseName;

    @FindBy(css = "button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedSecondary")
    @CacheLookup
    private WebElement delete;

    @FindBy(css = "button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary")
    @CacheLookup
    private WebElement save;

    /**
     * Click on Add Button
     *
     * @return the CoursePage class instance.
     */
    public CoursePage clickAddButton() {
        addButton.click();
        return this;
    }

    /**
     * Click on the first entry in the table.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage clickEntryFirst() {
        entryFirst.click();
        return this;
    }

    /**
     * Click on Courses Link.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage clickCoursesLink() {
        courses.click();
        return this;
    }

    /**
     * Click on Delete Button.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage clickDeleteButton() {
        delete.click();
        return this;
    }

    /**
     * Click on Save Button.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage clickSaveButton() {
        save.click();
        return this;
    }

    /**
     * Click on Settings Link.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage clickSettingsLink() {
        settings.click();
        return this;
    }

    /**
     * Click on Students Link.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage clickStudentsLink() {
        students.click();
        return this;
    }

    /**
     * Click on Teachers Link.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage clickTeachersLink() {
        teachers.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage fill() {
        setCourseNameTextField("CourseName");
        setCostPerClassNumberField("41");
        setClassPerWeekNumberField("41");
        return this;
    }
//    public CoursePage fill() {
//        setCourseNameTextField();
//        setCostPerClassNumberField();
//        setClassPerWeekNumberField();
//        return this;
//    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Class Per Week Number field.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage setClassPerWeekNumberField() {
        return setClassPerWeekNumberField(data.get("CLASS_PER_WEEK"));
    }

    /**
     * Set value to Class Per Week Number field.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage setClassPerWeekNumberField(String classPerWeekValue) {
        classesPerWeek.sendKeys(classPerWeekValue);
        return this;
    }

    /**
     * Set default value to Cost Per Class Number field.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage setCostPerClassNumberField() {
        return setCostPerClassNumberField(data.get("COST_PER_CLASS"));
    }

    /**
     * Set value to Cost Per Class Number field.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage setCostPerClassNumberField(String costPerClassValue) {
        costPerClass.sendKeys(costPerClassValue);
        return this;
    }

    /**
     * Set default value to Course Name Text field.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage setCourseNameTextField() {
        return setCourseNameTextField(data.get("COURSE_NAME"));
    }

    /**
     * Set value to Course Name Text field.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage setCourseNameTextField(String courseNameValue) {
        developerCourseName.sendKeys(courseNameValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the CoursePage class instance.
     */
    public CoursePage submit() {
        clickSaveButton();
        return this;
    }

//    /**
//     * Verify that the page loaded completely.
//     *
//     * @return the CoursePage class instance.
//     */
//    public CoursePage verifyPageLoaded() {
//        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getPageSource().contains(pageLoadedText);
//            }
//        });
//        return this;
//    }
//
//    /**
//     * Verify that current page URL matches the expected URL.
//     *
//     * @return the CoursePage class instance.
//     */
//    public CoursePage verifyPageUrl() {
//        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getCurrentUrl().contains(pageUrl);
//            }
//        });
//        return this;
//    }

}
