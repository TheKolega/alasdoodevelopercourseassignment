package demoqa.testCase;

import demoqa.pageObject.DemoQaHomePage;
import localhost.testCase.FunctionalTest;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.ConstEnum;
import utils.PageUtils;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoQaHomeTest extends FunctionalTest {

    DemoQaHomePage page;

    @BeforeEach
    public void setupEachDemoQaTest() {
        driver.get("http://demoqa.com");
        page = new DemoQaHomePage(driver);
        page.get();
    }

    @Test
    public void testElementsCardClick() {
        WebElement targetElement = null;
        String expectedText = "Elements";
        Actions action = new Actions(driver);

        targetElement = driver.findElement(By.xpath("//h5[text()='Elements']"));
        action.moveToElement(targetElement).click().perform();
        String actualText = driver.findElement(By.cssSelector(".main-header")).getText();
        MatcherAssert.assertThat(actualText, Matchers.containsStringIgnoringCase(expectedText));
    }

    @ParameterizedTest
    @EnumSource(value = ConstEnum.class, names = {"TEST_ACTION_PAUSE"}, mode = EnumSource.Mode.MATCH_ALL)
    public void testHoverAndClickWithPauseShowCursor(ConstEnum EnumPauseFor) throws IOException {
        int pauseFor = EnumPauseFor.getValue();
//        int pauseFor = 100;
        WebElement targetElement = null;
        String expectedText = "Book Store";
        Actions action = new Actions(driver);

        PageUtils.enableCursorViaJS(driver); //! Visual cursor injected to page, follows regular mouse movement if overlapping

        targetElement = driver.findElement(By.xpath("//h5[contains(text(),'Elements')]"));
        action.moveToElement(targetElement).pause(pauseFor).perform();
        targetElement = driver.findElement(By.xpath("//h5[contains(text(),'Forms')]"));
        action.moveToElement(targetElement).pause(pauseFor).perform();
        targetElement = driver.findElement(By.xpath("//h5[contains(text(),'Alerts')]"));
        action.moveToElement(targetElement).pause(pauseFor).perform();
        targetElement = driver.findElement(By.xpath("//h5[contains(text(),'Widgets')]"));
        action.moveToElement(targetElement).pause(pauseFor).perform();
        targetElement = driver.findElement(By.xpath("//h5[contains(text(),'Interactions')]"));
        action.moveToElement(targetElement).pause(pauseFor).perform();
        targetElement = driver.findElement(By.xpath("//h5[contains(text(),'Book')]"));
        action.moveToElement(targetElement).pause(pauseFor).perform();
        PageUtils.tryToClick(driver, targetElement);
        action.pause(pauseFor).perform();
        String actualText = driver.findElement(By.cssSelector(".main-header")).getText();
        MatcherAssert.assertThat(actualText, Matchers.containsStringIgnoringCase(expectedText));
    }
}
