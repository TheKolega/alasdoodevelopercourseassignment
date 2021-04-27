package testCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import pageObject.StudentPage;
import pageObject.TeacherPage;

public class TeacherTest extends FunctionalTest {

    private TeacherPage page = new TeacherPage(driver);

    @Test
    public void createTeacher() {
        driver.get("http://localhost:3000/teacher");
        assertTrue(page.isInitialized());


        page.clickTeachersLink();//! needed?
        page.clickAddButton();
        page.fillAndSubmit();
    }

    @Test
    public void updateTeacher() {
        driver.get("http://localhost:3000/teacher");
        assertTrue(page.isInitialized());

        page.clickTeachersLink(); //! needed?
        page.clickEntryFirst();
        page.setNameTextField("nameUpdated");
        page.setSurnameTextField("surnameUpdated");
        page.clickSaveButton();
    }

    @Test
    public void deleteTeacher() {
        driver.get("http://localhost:3000/teacher");
        assertTrue(page.isInitialized());


        page.clickTeachersLink(); //! needed?
        page.clickEntryFirst();
        page.clickDeleteButton();
    }

}
