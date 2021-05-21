package testCase;

import org.junit.jupiter.api.*;
import pageObject.TeacherPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TeacherTest extends FunctionalTest {

    private TeacherPage page;

    @BeforeEach
    public void setupEachTeacherTest() {
        driver.get("http://localhost:3000/teacher");
        page = new TeacherPage(driver);
//        assertTrue(page.isInitialized());
    }

    @Test
    @Order(1)
    public void createTeacher() {
        page.clickTeachersLink();//! needed?
        page.clickAddButton();
        page.fillAndSubmit();
    }

    @Test
    @Order(2)
    public void updateTeacher() {
        page.clickTeachersLink(); //! needed?
        page.clickEntryFirst();
        page.setNameTextField("nameUpdated");
        page.setSurnameTextField("surnameUpdated");
        page.clickSaveButton();
    }

    @Test
    @Order(3)
    public void deleteTeacher() {
        page.clickTeachersLink(); //! needed?
        page.clickEntryFirst();
        page.clickDeleteButton();
    }

}
