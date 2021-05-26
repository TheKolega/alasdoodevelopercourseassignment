package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utils.PageUtils;

import java.util.Map;

public class StudentPage extends PageObject<StudentPage> {

    private final String pageLoadedText = "";
    private final String pageUrl = "http://localhost:3000/student";
    private Map<String, String> data;
    //! map values to data

    public StudentPage(WebDriver driver) {
        super(driver);
    }

//    public StudentPage() {
//        super();
//    }
//
//    public StudentPage(WebDriver driver, Map<String, String> data) {
//        super(driver, data);
//    }
//
//    public StudentPage(WebDriver driver, Map<String, String> data, int timeout) {
//        super(driver, data, timeout);
//    }

    @Override
    protected void load() {
        this.driver.get(pageUrl);
    }

    @Override
    protected void isLoaded() throws Error {
//        Assertions.assertTrue(driver.getCurrentUrl().contains("student"), "Student page not loaded");

        PageUtils.isLoaded().
                waitForElementIsVisible(driver, students).
                waitForElementIsClickable(driver, students);
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
    private WebElement firstEntryValue;

    @FindBy(name = "name")
    @CacheLookup
    private WebElement name;

    @FindBy(name = "surname")
    @CacheLookup
    private WebElement surname;

    @FindBy(name = "accountName")
    @CacheLookup
    private WebElement accountName;

    @FindBy(name = "email")
    @CacheLookup
    private WebElement email;

    @FindBy(name = "bankCardNumber")
    @CacheLookup
    private WebElement bankCardNumber;

    @FindBy(xpath = "//button[@data-test-id='courses']")
    @CacheLookup
    private WebElement toggleCourses;

    @FindBy(xpath = "//button[@data-test-id='save']")
    @CacheLookup
    private WebElement save;

    @FindBy(xpath = "//button[@data-test-id='delete']")
    @CacheLookup
    private WebElement delete;


    /*

    //!
    @FindBy(nesto)
    @CacheLookup
    private WebElement entryValue;

    public StudentPage findEntry(String entry){

        return this;
    }

     */

    /**
     * Click on Students Link.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickStudentsLink() {
        students.click();
        return this;
    }

    /**
     * Click on Teachers Link.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickTeachersLink() {
        teachers.click();
        return this;
    }

    /**
     * Click on Courses Link.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickCoursesLink() {
        courses.click();
        return this;
    }

    /**
     * Click on Settings Link.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickSettingsLink() {
        settings.click();
        return this;
    }

    /**
     * Click on Add Button
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickAddButton() {
        addButton.click();
        return this;
    }

    /**
     * Click on Next Page Button
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickNextPageButton() {
        nextPage.click();
        return this;
    }

    /**
     * Click on Previous Page Button
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickPreviousPageButton() {
        previousPage.click();
        return this;
    }

    /**
     * Click on the first entry in the table.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickEntryFirst() {
        firstEntryValue.click();
        return this;
    }

    /**
     *
     */
    public StudentPage clearElement(WebElement element) {
        //! Clear method isn't a proper user input
        //! Clear method doesn't work on Chrome with React Text
        element.clear();
        return this;
    }

    /**
     * Set default value to Name Text field.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage setNameTextField() {
        return setNameTextField(data.get("NAME"));
    }

    /**
     * Set value to Name Text field.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage setNameTextField(String nameValue) {
        name.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        name.sendKeys(nameValue);
        return this;
    }

    /**
     * Set default value to Surname Text field.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage setSurnameTextField() {
        return setSurnameTextField(data.get("SURNAME"));
    }

    /**
     * Set value to Surname Text field.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage setSurnameTextField(String surnameValue) {
        surname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        surname.sendKeys(surnameValue);
        return this;
    }

    /**
     * Set default value to Account Name Text field.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage setAccountNameTextField() {
        return setAccountNameTextField(data.get("ACCOUNT_NAME"));
    }

    /**
     * Set value to Account Name Text field.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage setAccountNameTextField(String accountNameValue) {
        accountName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        accountName.sendKeys(accountNameValue);
        return this;
    }

    /**
     * Set default value to Email Email field.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage setEmailEmailField() {
        return setEmailEmailField(data.get("EMAIL"));
    }

    /**
     * Set value to Email Email field.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage setEmailEmailField(String emailValue) {
        email.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        email.sendKeys(emailValue);
        return this;
    }

    /**
     * Set default value to Bank Card Number Text field.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage setBankCardNumberTextField() {
        return setBankCardNumberTextField(data.get("BANK_CARD_NUMBER"));
    }

    /**
     * Set value to Bank Card Number Text field.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage setBankCardNumberTextField(String bankCardNumberValue) {
        bankCardNumber.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        bankCardNumber.sendKeys(bankCardNumberValue);
        return this;
    }

    /**
     * Click on Toggle Courses Button.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickToggleCoursesButton() {
        toggleCourses.click();
        return this;
    }

    /**
     * Click on Save Button.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickSaveButton() {
        save.click();
        return this;
    }

    /**
     * Click on Delete Button.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickDeleteButton() {
        delete.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage fill() {
        setNameTextField("StudentName");
        setSurnameTextField("StudentSurname");
        setAccountNameTextField("name_surname");
        setEmailEmailField("stu@dent.com");
        setBankCardNumberTextField("4141");
        return this;
    }
//    public StudentPage fill() {
//        setNameTextField();
//        setSurnameTextField();
//        setAccountNameTextField();
//        setEmailEmailField();
//        setBankCardNumberTextField();
//        return this;
//    }

    /**
     * Submit the form to target page.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage submit() {
        clickSaveButton();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage fillAndSubmit() {
        fill();
        return submit();
    }


    /**
     * Go from the Students page to the Settings page
     *
     * @return the SettingsPage class instance.
     */
    public SettingsPage goToSettingsPage() {
        clickSettingsLink();
        return new SettingsPage(this.driver, this);
    }

//    /**
//     * Verify that the page loaded completely.
//     *
//     * @return the StudentPage class instance.
//     */
//    public StudentPage verifyPageLoaded() {
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
//     * @return the StudentPage class instance.
//     */
//    public StudentPage verifyPageUrl() {
//        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getCurrentUrl().contains(pageUrl);
//            }
//        });
//        return this;
//    }

}
