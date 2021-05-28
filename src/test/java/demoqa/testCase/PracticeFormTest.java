package demoqa.testCase;

import demoqa.pageObject.AppPage;
import demoqa.pageObject.DemoQaHomePage;
import localhost.testCase.FunctionalTest;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConstEnum;
import utils.PageUtils;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PracticeFormTest extends FunctionalTest {

    private AppPage page;
    private DemoQaHomePage parent;

    @BeforeEach
    public void setupEachPracticeFormTest() {
        driver.get("http://demoqa.com/automation-practice-form");
        page = new AppPage(driver, parent);
        page.get();
        page.clickElements();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataForm.csv", numLinesToSkip = 1)
    public void completeFormTest(String firstName, String lastName, String email, String gender,
                                 String mobileNumber, String subject1, String subject2, String currentAddress) throws IOException {
        //! How to fit a subject list of differing dimensions in the csv? separate in csv with _ and split in code?
        WebElement targetElement = null;
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, ConstEnum.BASIC_WAIT_TIME_IN_SECONDS.getValue());

//        targetElement = driver.findElement(By.cssSelector("a[id*='preventPropogation']"));
//        targetElement = driver.findElement(By.cssSelector("#dragBox"));

        targetElement = driver.findElement(By.cssSelector("#firstName"));
        action.moveToElement(targetElement).click().sendKeys(firstName).perform();

        targetElement = driver.findElement(By.cssSelector("#lastName"));
        action.moveToElement(targetElement).click().sendKeys(lastName).perform();

        targetElement = driver.findElement(By.cssSelector("#userEmail"));
        action.moveToElement(targetElement).click().sendKeys(email).perform();

        switch (gender) {
            case "male":
                targetElement = driver.findElement(By.cssSelector("#gender-radio-1"));
                action.moveToElement(targetElement).click().perform();
                break;
            case "female":
                targetElement = driver.findElement(By.cssSelector("#gender-radio-2"));
                action.moveToElement(targetElement).click().perform();
                break;
            case "other":
                targetElement = driver.findElement(By.cssSelector("#gender-radio-3"));
                action.moveToElement(targetElement).click().perform();
                break;
            default:
                targetElement = driver.findElement(By.cssSelector("#gender-radio-3"));
                action.moveToElement(targetElement).click().perform();
                break;
        }

        targetElement = driver.findElement(By.cssSelector("#userNumber"));
        action.moveToElement(targetElement).click().sendKeys(mobileNumber).perform();

        //! Date picker
//        targetElement = driver.findElement(By.cssSelector("#dateOfBirthInput"));
        PageUtils.enableCursorViaJS(driver);

        //! subjects must be matched with list
        targetElement = driver.findElement(By.cssSelector("#subjectsContainer"));
        action.moveToElement(targetElement).click().sendKeys(subject1).perform();
        action.pause(1000);
        action.moveToElement(targetElement, 0, -60).click().perform();
        action.pause(1000);
        action.moveToElement(targetElement).click().sendKeys(subject2).perform();
        action.pause(1000);

        //! implement hobbies select via split string?
        targetElement = driver.findElement(By.cssSelector("#hobbies-checkbox-1"));
        action.moveToElement(targetElement).click().perform();
        targetElement = driver.findElement(By.cssSelector("#hobbies-checkbox-3"));
        action.moveToElement(targetElement).click().perform();

        //! Use file picker? Pass relative path?
        targetElement = driver.findElement(By.cssSelector("#uploadPicture"));
        targetElement.sendKeys("/home/miloswedoqa/Documents/Projects/alasdoodevelopercourseassignment/src/test/resources/testPicture.jpg");

        targetElement = driver.findElement(By.cssSelector("#currentAddress"));
        action.moveToElement(targetElement).click().sendKeys(currentAddress).perform();

        //! choose by reading the list and matching?
        targetElement = driver.findElement(By.cssSelector("#state"));
        action.moveToElement(targetElement).click().perform();
        action.moveToElement(targetElement, 0, 50).click().perform();
        targetElement = driver.findElement(By.cssSelector("#city"));
        action.moveToElement(targetElement).click().perform();
        action.moveToElement(targetElement, 0, 50).click().perform();


        targetElement = driver.findElement(By.cssSelector("#submit"));
        action.moveToElement(targetElement).click().perform();

        driver.switchTo().activeElement();
        targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector("#example-modal-sizes-title-lg")));
        String actualText = targetElement.getText();
        MatcherAssert.assertThat(actualText, Matchers.containsStringIgnoringCase("Thanks for submitting"));
        action.pause(2000).perform();
    }
}
