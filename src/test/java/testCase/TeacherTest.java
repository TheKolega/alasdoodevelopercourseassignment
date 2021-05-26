package testCase;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import pageObject.TeacherPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TeacherTest extends FunctionalTest {

    private TeacherPage page;

    @BeforeEach
    public void setupEachTeacherTest() {
        driver.get("http://localhost:3000/teacher");
        page = new TeacherPage(driver);
        page.get();
    }

    @Test
    @Order(4)
    public void createTeacher() {
        System.out.println("TeacherTest1Create");

        String nameDefault = "TeacherName";
        String surnameDefault = "TeacherSurname";
        String emailDefault = "tea@cher.com";
        WebElement targetElement = null;

        page.clickAddButton();
        page.setNameTextField(nameDefault);
        page.setSurnameTextField(surnameDefault);
        page.setEmailEmailField(emailDefault);
        page.submit();
        targetElement = seekTillLastPage(page, nameDefault);
        MatcherAssert.assertThat(targetElement.getText(), Matchers.equalToIgnoringCase(nameDefault));
    }

    @Test
    @Order(5)
    public void updateTeacher() throws InterruptedException {
        System.out.println("TeacherTest2Update");

        String nameUpdated = "UpdatedName";
        String surnameUpdated = "UpdatedSurname";
        String emailUpdated = "teaUpd@cher.com";
        WebElement targetElement = null;


        page.clickEntryFirst();
        page.setNameTextField(nameUpdated);
        page.setSurnameTextField(surnameUpdated);
        page.setEmailEmailField(emailUpdated);
        page.submit();
        targetElement = seekTillLastPage(page, nameUpdated);
        if (targetElement != null) {
            MatcherAssert.assertThat(targetElement.getText(), Matchers.equalToIgnoringCase(nameUpdated));
        } else {
            Assertions.fail("No target element found");
        }
    }

    @Test
    @Order(6)
    public void deleteTeacher() {
        System.out.println("TeacherTest3Delete");

        String nameToDelete = "TeacherName";
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
