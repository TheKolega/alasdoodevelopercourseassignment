package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utils.PageUtils;

import java.util.Map;

public class TeacherPage extends PageObject<TeacherPage> {

    private final String pageLoadedText = "";
    private final String pageUrl = "http://localhost:3000/teacher";
    private Map<String, String> data;
    //! map values to data

    public TeacherPage(WebDriver driver) {
        super(driver);
    }

//    public TeacherPage() {
//        super();
//    }
//
//    public TeacherPage(WebDriver driver, Map<String, String> data) {
//        super(driver, data);
//    }
//
//    public TeacherPage(WebDriver driver, Map<String, String> data, int timeout) {
//        super(driver, data, timeout);
//    }

    @Override
    protected void load() {
        this.driver.get(pageUrl);
    }

    @Override
    protected void isLoaded() throws Error {
//        Assertions.assertTrue(driver.getCurrentUrl().contains(pageUrl), "Teacher page not loaded");

        PageUtils.isLoaded().
                waitForElementIsVisible(driver, teachers).
                waitForElementIsClickable(driver, teachers);
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

    @FindBy(xpath = "//button[@aria-label='add']")
    @CacheLookup
    private WebElement addButton;

    @FindBy(xpath = "//div[@class='MuiTablePagination-actions']//button[@title='Next page']")
    @CacheLookup
    private WebElement nextPage;

    @FindBy(xpath = "//div[@class='MuiTablePagination-actions']//button[@title='Previous page']")
    @CacheLookup
    private WebElement previousPage;

    @FindBy(css = ".MuiDataGrid-row:nth-child(1) > .MuiDataGrid-cell:nth-child(1)")
    @CacheLookup
    private WebElement entryFirst;

    @FindBy(name = "teacherEmail")
    @CacheLookup
    private WebElement email;

    @FindBy(name = "teacherName")
    @CacheLookup
    private WebElement name;

    @FindBy(name = "teacherSurname")
    @CacheLookup
    private WebElement surname;

    @FindBy(xpath = "//button[@data-test-id='courses']")
    @CacheLookup
    private WebElement toggleCourses;

    @FindBy(xpath = "//button[@data-test-id='save']")
    @CacheLookup
    private WebElement save;

    @FindBy(xpath = "//button[@data-test-id='delete']")
    @CacheLookup
    private WebElement delete;

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
     * Click on Next Page Button
     *
     * @return the TeacherPage class instance.
     */
    public TeacherPage clickNextPageButton() {
        nextPage.click();
        return this;
    }

    /**
     * Click on Previous Page Button
     *
     * @return the StudentPage class instance.
     */
    public TeacherPage clickPreviousPageButton() {
        previousPage.click();
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
        setNameTextField("TeacherName");
        setSurnameTextField("TeacherSurname");
        setEmailEmailField("tea@cher.com");
        return this;
    }
//    public TeacherPage fill() {
//        setNameTextField();
//        setSurnameTextField();
//        setEmailEmailField();
//        return this;
//    }

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
        email.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
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
        name.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
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
        surname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
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

//    /**
//     * Verify that the page loaded completely.
//     *
//     * @return the TeacherPage class instance.
//     */
//    public TeacherPage verifyPageLoaded() {
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
//     * @return the TeacherPage class instance.
//     */
//    public TeacherPage verifyPageUrl() {
//        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getCurrentUrl().contains(pageUrl);
//            }
//        });
//        return this;
//    }

}
