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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConstEnum;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DroppableTest extends FunctionalTest {

    private AppPage page;
    private DemoQaHomePage parent;

    @BeforeEach
    public void setupEachDroppableTest() {
        driver.get("http://demoqa.com/droppable");
        page = new AppPage(driver, parent);
        page.get();
        page.clickElements();
    }

    @Test
    public void testInteractionsDroppablePreventPropagation() {
        WebElement targetElement = null;
        String expectedText = "Dropped!";
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, ConstEnum.BASIC_WAIT_TIME_IN_SECONDS.getValue());

//        PageUtils.enableCursorViaJS(driver); //! Visual cursor injected to page, follows regular mouse movement if overlapping

        targetElement = driver.findElement(By.cssSelector("a[id*='preventPropogation']"));
        action.moveToElement(targetElement).click().perform();

        WebElement dragThis = driver.findElement(By.cssSelector("#dragBox"));
        List<WebElement> dropHere = driver.findElements(By.cssSelector("div[id*='DropBox']"));
        List<String> actualTexts = new ArrayList<>();

        for (WebElement el : dropHere) {
//            action.pause(1000).perform();
            action.dragAndDrop(dragThis, el).perform();
//            action.pause(1000).perform();
            action.dragAndDropBy(dragThis, 0, -100).perform();
//            action.pause(1000).perform();
            wait.until(ExpectedConditions.attributeContains(el, "class", "ui-state-highlight"));
            actualTexts.add(el.getText());
        }
//        action.pause(1000).perform();
        for (String text : actualTexts) {
            System.out.println(text); //! zasto ispisuje 6 puta?
            MatcherAssert.assertThat(text, Matchers.containsStringIgnoringCase(expectedText));
        }
    }
}
