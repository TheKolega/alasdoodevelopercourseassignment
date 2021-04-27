package testCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

/**
 * <strong>testCase.FunctionalTest</strong> handles setup and teardown of WebDriver.
 *
 * @author Kim Schiller
 */
public class FunctionalTest {

    protected static WebDriver driver;

/*
    static {
        System.setProperty("webdriver.gecko.driver", findFile("geckodriver.exe"));
    }
*/

    Path path = FileSystems.getDefault().getPath("geckodriver.exe");
    {
        System.setProperty("webdriver.gecko.driver", path.toString());
    }


    static private String findFile(String filename) {
        String paths[] = {"", "bin/", "target/classes"};
        for (String path : paths) {
            if (new File(path + filename).exists())
                return path + filename;
        }
        return "";
    }

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }
}
