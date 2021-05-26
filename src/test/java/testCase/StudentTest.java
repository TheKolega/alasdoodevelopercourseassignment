package testCase;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import pageObject.StudentPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentTest extends FunctionalTest {

    private StudentPage page;

    @BeforeEach
    public void setupEachStudentTest() {
        driver.get("http://localhost:3000/student");
        page = new StudentPage(driver);
        page.get();
    }

    @Test
    @Order(1)
    public void createStudent() {
        System.out.println("StudentTest1Create");

        String nameDefault = "StudentName";
        String surnameDefault = "StudentSurname";
        String accountNameDefault = "name_surname";
        String emailDefault = "stu@dent.com";
        String bankCardNumberDefault = "4141";
        WebElement targetElement = null;

        page.clickAddButton();
        page.setNameTextField(nameDefault);
        page.setSurnameTextField(surnameDefault);
        page.setAccountNameTextField(accountNameDefault);
        page.setEmailEmailField(emailDefault);
        page.setBankCardNumberTextField(bankCardNumberDefault);
        page.submit();
        targetElement = seekTillLastPage(page, nameDefault);
        MatcherAssert.assertThat(targetElement.getText(), Matchers.equalToIgnoringCase(nameDefault));
    }

    @Test
    @Order(2)
    public void updateStudent() {
        System.out.println("StudentTest2Update");

        String nameUpdated = "UpdatedName";
        String surnameUpdated = "UpdatedSurname";
        WebElement targetElement = null;

        page.clickEntryFirst();
        page.setNameTextField(nameUpdated);
        page.setSurnameTextField(surnameUpdated);
        page.submit();
        targetElement = seekTillLastPage(page, nameUpdated);
        //! Moze ovo i bolje
        if (targetElement != null) {
            MatcherAssert.assertThat(targetElement.getText(), Matchers.equalToIgnoringCase(nameUpdated));
        } else {
            Assertions.fail("No target element found");
        }
    }

    @Test
    @Order(3)
    public void deleteStudent() {
        System.out.println("StudentTest3Delete");

        String nameToDelete = "StudentName";
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
