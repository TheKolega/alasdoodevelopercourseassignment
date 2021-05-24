package testCase;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.StudentPage;

import java.util.List;

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
//        page.clickStudentsLink();//! needed?
        page.clickAddButton();
        page.fillAndSubmit();
        String defaultName = "StudentName";
        List<WebElement> names = driver.findElements(By.xpath("//div[@data-value='" + defaultName + "']"));
        //Assertions.assertFalse(names.isEmpty());
        Assertions.assertEquals(names.get(0).getText().toLowerCase(), defaultName.toLowerCase());
        // Check other pages?

        //Assert number of students increased?
        //Assert name given is in table
    }

    @Test
    @Order(2)
    public void updateStudent() {
//        page.clickStudentsLink(); //! needed?
        page.clickEntryFirst();
        page.setNameTextField("nameUpdated");
        page.setSurnameTextField("surnameUpdated");
        page.clickSaveButton();
        //Assert name given is in table
    }

    @Test
    @Order(3)
    public void deleteStudent() {
//        page.clickStudentsLink(); //! needed?
        String defaultName = "StudentName";
        WebElement testElement;
        testElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//div[@data-value='" + defaultName + "']")));
        testElement.click();
//        page.clickEntryFirst();
        page.clickDeleteButton();
        // Assert name given is no longer in table
        // Check other pages?

    }

    @Test
    public void clickNextPageButton() throws InterruptedException {
        page.clickStudentsLink(); //! needed?
        page.clickAddButton(); // otherwise Next Page button hidden behind this
        Thread.sleep(2000);
        WebElement testElement;
        testElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiTablePagination-actions']//button[@title='Next page']")));
        Thread.sleep(2000);
        testElement.click();
//        page.clickNextPageButton();
    }

}
