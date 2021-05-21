package testCase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

/**
 * <strong>testCase.FunctionalTest</strong> handles setup and teardown of WebDriver.
 *
 * @author Milos
 */
public class FunctionalTest {

    protected static WebDriver driver;
    static Path pathChrome = Path.of("src/test/resources/webdrivers_linux/chromedriver");
    static Path pathGecko = Path.of("src/test/resources/webdrivers_linux/geckodriver");

    {
        System.setProperty("webdriver.gecko.driver", pathGecko.toString());
    }
    //static Path path = FileSystems.getDefault().getPath("webdrivers_linux/geckodriver");

/* FIND FILE

    static {
        System.setProperty("webdriver.gecko.driver", findFile("geckodriver.exe"));
    }

    static private String findFile(String filename) {
        String[] paths = {"", "bin/", "target/classes"};
        for (String path : paths) {
            if (new File(path + filename).exists())
                return path + filename;
        }
        return "";
    }
*/

    @BeforeAll
    public static void setupAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    public void setupEach() {
        System.out.println("BeforeEach");
        //System.setProperty("webdriver.chrome.driver", pathChrome.toString());


        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDownEach() {
        System.out.println("AfterEach");
        driver.quit();
    }

    @AfterAll
    public static void TearDownAll() {
        System.out.println("AfterAll");
    }

}
