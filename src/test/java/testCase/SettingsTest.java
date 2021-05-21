package testCase;

import org.junit.jupiter.api.*;
import pageObject.SettingsPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SettingsTest extends FunctionalTest {

    private SettingsPage page;

    @BeforeEach
    public void setupEachStudentTest() {
        driver.get("http://localhost:3000/student");
        page = new SettingsPage(driver);
        Assertions.assertTrue(page.isInitialized());
    }

    @Test
    public void testSettings() {
        page.clickSettingsLink();//! needed?
    }
}
