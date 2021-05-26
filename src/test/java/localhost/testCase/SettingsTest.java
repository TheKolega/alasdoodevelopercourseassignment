package localhost.testCase;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import localhost.pageObject.SettingsPage;
import localhost.pageObject.StudentPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SettingsTest extends FunctionalTest {

    private SettingsPage page;

    @BeforeEach
    public void setupEachSettingsTest() {
        driver.get("http://localhost:3000/settings");
        StudentPage parent = new StudentPage(driver);
        page = new SettingsPage(driver, parent);
        page.get();
    }

    @Test
    @Order(10)
    public void testSettingsTextExists() {
        System.out.println("SettingsTest1TextExists");

        String expectedText = "Inject demo content in the backend. Run this command only once!";
        String actualText = driver.findElement(By.cssSelector("p.MuiTypography-root")).getText();
        MatcherAssert.assertThat(actualText, Matchers.containsStringIgnoringCase(expectedText));
    }
}
