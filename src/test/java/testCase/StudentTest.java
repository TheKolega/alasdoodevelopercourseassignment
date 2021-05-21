package testCase;

import org.junit.jupiter.api.*;
import pageObject.StudentPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentTest extends FunctionalTest {

    private StudentPage page;

    @BeforeEach
    public void setupEachStudentTest() {
        driver.get("http://localhost:3000/student");
        page = new StudentPage(driver);
//        assertTrue(page.isInitialized());
    }

    @Test
    @Order(1)
    public void createStudent() {
        page.clickStudentsLink();//! needed?
        page.clickAddButton();
        page.fillAndSubmit();
    }

    @Test
    @Order(2)
    public void updateStudent() {
        page.clickStudentsLink(); //! needed?
        page.clickEntryFirst();
        page.setNameTextField("nameUpdated");
        page.setSurnameTextField("surnameUpdated");
        page.clickSaveButton();
    }

    @Test
    @Order(3)
    public void deleteStudent() {
         page.clickStudentsLink(); //! needed?
        page.clickEntryFirst();
        page.clickDeleteButton();
    }

}
