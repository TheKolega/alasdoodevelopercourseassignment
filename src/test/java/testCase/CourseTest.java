package testCase;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import pageObject.CoursePage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseTest extends FunctionalTest {

    CoursePage page;

    @BeforeEach
    public void setupEachCourseTest() {
        driver.get("http://localhost:3000/course");
        page = new CoursePage(driver);
        page.get();
    }

    @Test
    @Order(7)
    public void createCourse() {
        System.out.println("CourseTest1Create");

        String nameDefault = "CourseName";
        String costDefault = "42";
        String numberDefault = "4";
        WebElement targetElement = null;

        page.clickAddButton();
        page.setCourseNameTextField(nameDefault);
        page.setCostPerClassNumberField(costDefault);
        page.setClassPerWeekNumberField(numberDefault);
        page.submit();
        targetElement = seekTillLastPage(page, nameDefault);
        MatcherAssert.assertThat(targetElement.getText(), Matchers.equalToIgnoringCase(nameDefault));
    }

    @Test
    @Order(8)
    public void updateCourse() {
        System.out.println("CourseTest2Update");

        String nameUpdated = "UpdatedName";
        String costUpdated = "111";
        String numberUpdated = "111";
        WebElement targetElement = null;

        page.clickEntryFirst();
        page.setCourseNameTextField(nameUpdated);
        page.setCostPerClassNumberField(costUpdated);
        page.setClassPerWeekNumberField(numberUpdated);
        page.submit();
        targetElement = seekTillLastPage(page, nameUpdated);
        if (targetElement != null) {
            MatcherAssert.assertThat(targetElement.getText(), Matchers.equalToIgnoringCase(nameUpdated));
        } else {
            Assertions.fail("No target element found");
        }
    }

    @Test
    @Order(9)
    public void deleteCourse() {
        System.out.println("CourseTest3Delete");

        String nameToDelete = "CourseName";
        WebElement targetToDelete = null;
        WebElement targetToCheck = null;

        targetToDelete = seekTillLastPage(page, nameToDelete);
        targetToDelete.click();
        page.clickDeleteButton();
        // Return to first page
        driver.navigate().refresh();
        targetToCheck = seekTillLastPage(page, nameToDelete);
        MatcherAssert.assertThat(targetToCheck, Matchers.is(Matchers.nullValue()));
    }

}
