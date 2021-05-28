package demoqa.testCase;

import demoqa.pageObject.AppPage;
import demoqa.pageObject.DemoQaHomePage;
import localhost.testCase.FunctionalTest;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConstEnum;
import utils.PageUtils;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest extends FunctionalTest {

    private AppPage page;
    private DemoQaHomePage parent;

    @BeforeEach
    public void setupEachAppTest() {
        driver.get("http://demoqa.com/elements");
        page = new AppPage(driver, parent);
        page.get();
        page.clickElements();
    }

    @Test
//    @EnumSource(value = ConstEnum.class, names = {"TEST_ACTION_PAUSE"}, mode = EnumSource.Mode.MATCH_ALL)
    public void testInteractionsDroppablePreventPropagation() throws IOException {
//        int pauseFor = EnumPauseFor.getValue();
        int pauseFor = 2000;
        WebElement targetElement = null;
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, ConstEnum.BASIC_WAIT_TIME_IN_SECONDS.getValue());

        PageUtils.enableCursorViaJS(driver); //! Visual cursor injected to page, follows regular mouse movement if overlapping
        action.pause(pauseFor).perform();

        targetElement = driver.findElement(By.cssSelector("div:nth-child(5) > span"));
        action.moveToElement(targetElement).click().perform();
        action.pause(pauseFor).perform();

        targetElement = driver.findElement(By.xpath("//span[contains(text(),'Droppable')]"));
        PageUtils.scrollIntoView(driver, driver.findElement(By.cssSelector("div:nth-child(6) > span")));
        action.pause(pauseFor).perform();
        action.moveToElement(targetElement).click().perform();
        action.pause(pauseFor).perform();


        targetElement = driver.findElement(By.cssSelector("a[id*='preventPropogation']"));
        action.moveToElement(targetElement).click().perform();
        action.pause(pauseFor).perform();

        String actualText = targetElement.getAttribute("aria-selected");
        MatcherAssert.assertThat(actualText, Matchers.equalToIgnoringCase("true"));

    }

    //    @Test
    public void testDifferentSelectors() throws IOException {
        int pauseFor = 600;
        WebElement targetElement = null;
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement homePageLogo = driver.findElement(By.xpath("//a[@href='https://demoqa.com']"));

        PageUtils.enableCursorViaJS(driver); //! Visual cursor injected to page, follows regular mouse movement if overlapping
        action.pause(pauseFor).perform();

        // XPath is slow
        targetElement = driver.findElement(By.xpath("//div[contains(text(),'Interactions')]"));
        action.moveToElement(targetElement).click().perform();
        action.pause(pauseFor).perform();
        action.moveToElement(homePageLogo).pause(600).perform();

        // Depends on order staying the same
        targetElement = driver.findElement(By.cssSelector("div:nth-child(3) > span"));
        action.moveToElement(targetElement).pause(pauseFor).perform();
        action.moveToElement(homePageLogo).pause(600).perform();

//        targetElement = driver.findElement(By.cssSelector("div[text='Interactions']"));
//        action.moveToElement(targetElement).pause(pauseFor).perform();
//        action.moveToElement(homePageLogo).pause(600).perform();

//        targetElement = driver.findElement(By.cssSelector("span[text='Interactions']"));
//        action.moveToElement(targetElement).pause(pauseFor).perform();
//        action.moveToElement(homePageLogo).pause(600).perform();

//        targetElement = driver.findElement(By.cssSelector("div[text='Interactions'] or div[innertext='Interactions']"));
//        action.moveToElement(targetElement).pause(pauseFor).perform();
//        action.moveToElement(homePageLogo).pause(600).perform();

//        targetElement = driver.findElement(By.cssSelector("div:contains(Interactions)"));
//        action.moveToElement(targetElement).pause(pauseFor).perform();
//        action.moveToElement(homePageLogo).pause(600).perform();
    }
}
