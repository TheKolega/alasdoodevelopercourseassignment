package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class StudentPage extends PageObject {

    private final String pageLoadedText = "";
    private final String pageUrl = "http://localhost:3000/student"; //! full url?
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

    @FindBy(id = "formik-text-field-122")
    @CacheLookup
    private WebElement accountName;

    @FindBy(id = "formik-text-field-126")
    @CacheLookup
    private WebElement bankCardNumber;

    @FindBy(css = "button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedSecondary")
    @CacheLookup
    private WebElement delete;

    @FindBy(id = "formik-text-field-124")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "formik-text-field-118")
    @CacheLookup
    private WebElement name;

    @FindBy(css = "button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary")
    @CacheLookup
    private WebElement save;

    @FindBy(id = "formik-text-field-120")
    @CacheLookup
    private WebElement surname;


    @FindBy(css = "button.MuiButtonBase-root.MuiButton-root.MuiButton-text")
    @CacheLookup
    private WebElement toggleCourses;

    public StudentPage(WebDriver driver) {
        super(driver);
        //assertTrue(students.isDisplayed()); //! asserts?
    }

    public boolean isInitialized() {
        return students.isDisplayed();
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
     * Click on the first entry in the table.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickEntryFirst() {
        entryFirst.click();
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
     * Click on Delete Button.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickDeleteButton() {
        delete.click();
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
     * Click on Settings Link.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickSettingsLink() {
        settings.click();
        return this;
    }

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
     * Click on Toggle Courses Button.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage clickToggleCoursesButton() {
        toggleCourses.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage fill() {
        setNameTextField();
        setSurnameTextField();
        setAccountNameTextField();
        setEmailEmailField();
        setBankCardNumberTextField();
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
        accountName.sendKeys(accountNameValue);
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
        bankCardNumber.sendKeys(bankCardNumberValue);
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
        email.sendKeys(emailValue);
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
        surname.sendKeys(surnameValue);
        return this;
    }

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
     * Verify that the page loaded completely.
     *
     * @return the StudentPage class instance.
     */
    public StudentPage verifyPageLoaded() {
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
     * @return the StudentPage class instance.
     */
    public StudentPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

}
