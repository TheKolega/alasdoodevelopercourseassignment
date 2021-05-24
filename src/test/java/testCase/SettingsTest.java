package testCase;

import org.junit.jupiter.api.*;
import pageObject.SettingsPage;
import pageObject.StudentPage;

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
    public void testSettings() {
        page.clickSettingsLink();//! needed?
    }
}
