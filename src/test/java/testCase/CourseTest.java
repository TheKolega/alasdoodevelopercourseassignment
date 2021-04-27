package testCase;

import org.junit.Test;
import pageObject.CoursePage;

import static org.junit.Assert.assertTrue;

public class CourseTest extends FunctionalTest {

    private CoursePage page = new CoursePage(driver);

    @Test
    public void createCourse() {
        driver.get("http://localhost:3000/course");
        assertTrue(page.isInitialized());

        page.clickCoursesLink();//! needed?
        page.clickAddButton();
        page.fillAndSubmit();
    }

    @Test
    public void updateCourse() {
        driver.get("http://localhost:3000/course");
        assertTrue(page.isInitialized());

        page.clickCoursesLink(); //! needed?
        page.clickEntryFirst();
        page.setClassPerWeekNumberField("42");
        page.setCostPerClassNumberField("42");
        page.clickSaveButton();
    }

    @Test
    public void deleteCourse() {
        driver.get("http://localhost:3000/course");
        assertTrue(page.isInitialized());

        page.clickCoursesLink(); //! needed?
        page.clickEntryFirst();
        page.clickDeleteButton();
    }

}
