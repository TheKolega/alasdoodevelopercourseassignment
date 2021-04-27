package testCase;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import pageObject.StudentPage;

import static org.junit.Assert.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentTest extends FunctionalTest {

    private StudentPage page = new StudentPage(driver);

    @BeforeAll
	public static void driverGet() {
		driver.get("http://localhost:3000/student");
	}

    @Test
    @Order(1)
    public void createStudent() {
        assertTrue(page.isInitialized());

        page.clickStudentsLink();//! needed?
        page.clickAddButton();
        page.fillAndSubmit();
    }

    @Test
    @Order(2)
    public void updateStudent() {
        assertTrue(page.isInitialized());

        page.clickStudentsLink(); //! needed?
        page.clickEntryFirst();
        page.setNameTextField("nameUpdated");
        page.setSurnameTextField("surnameUpdated");
        page.clickSaveButton();
    }

    @Test
    @Order(3)
    public void deleteStudent() {
        assertTrue(page.isInitialized());

        page.clickStudentsLink(); //! needed?
        page.clickEntryFirst();
        page.clickDeleteButton();
    }

}
