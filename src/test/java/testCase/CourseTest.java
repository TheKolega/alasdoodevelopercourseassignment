package testCase;

import org.junit.jupiter.api.*;
import pageObject.CoursePage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseTest extends FunctionalTest {

    CoursePage page;

    @BeforeEach
    public void setupEachCourseTest() {
        driver.get("http://localhost:3000/course");
        page = new CoursePage(driver);
//        assertTrue(page.isInitialized());
    }

    @Test
    @Order(7)
    public void createCourse() {
        System.out.println("CourseTest1");

        page.clickCoursesLink();//! needed?
        page.clickAddButton();
        page.fillAndSubmit();
    }

    @Test
    @Order(8)
    public void updateCourse() {
        System.out.println("CourseTest2");

        page.clickCoursesLink(); //! needed?
        page.clickEntryFirst();
        page.setClassPerWeekNumberField("42");
        page.setCostPerClassNumberField("42");
        page.clickSaveButton();
    }

    @Test
    @Order(9)
    public void deleteCourse() {
        System.out.println("CourseTest3");

        page.clickCoursesLink(); //! needed?
        page.clickEntryFirst();
        page.clickDeleteButton();
    }

}
