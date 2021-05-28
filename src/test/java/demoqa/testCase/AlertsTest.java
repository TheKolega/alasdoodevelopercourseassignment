package demoqa.testCase;

import demoqa.pageObject.AppPage;
import demoqa.pageObject.DemoQaHomePage;
import localhost.testCase.FunctionalTest;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConstEnum;

public class AlertsTest extends FunctionalTest {

    private AppPage page;
    private DemoQaHomePage parent;

    @BeforeEach
    public void setupEachPracticeFormTest() {
        driver.get("http://demoqa.com/alerts");
        page = new AppPage(driver, parent);
        page.get();
        page.clickElements();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataAlerts.csv", numLinesToSkip = 1)
    public void promptBoxTest(String input, String expected) {
        WebElement targetElement = null;
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, ConstEnum.BASIC_WAIT_TIME_IN_SECONDS.getValue());

        targetElement = driver.findElement(By.cssSelector("#promtButton"));
        action.moveToElement(targetElement).click().perform();
        driver.switchTo().alert().sendKeys(input);
        driver.switchTo().alert().accept();
        targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#promptResult")));
        String actualText = targetElement.getText();
        MatcherAssert.assertThat(actualText, Matchers.containsStringIgnoringCase(expected));
    }
}