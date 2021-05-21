package testCase;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

/**
 * <strong>testCase.FunctionalTest</strong> handles setup and teardown of WebDriver.
 *
 * @author Milos
 */
public class FunctionalTest {

    protected static WebDriver driver;

    final String firefox = "firefox";
    private static final Path pathFirefox = Path.of("src/test/resources/webdrivers_linux/geckodriver");

    final String chrome = "chrome";
    private static final Path pathChrome = Path.of("src/test/resources/webdrivers_linux/chromedriver");

    final String opera = "opera";
    private static final Path pathOpera = Path.of("src/test/resources/webdrivers_linux/operadriver");

    final String edge = "edge";
    private static final Path pathEdge = Path.of("src/test/resources/webdrivers_linux/msedgedriver");

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

        System.setProperty("webdriver.gecko.driver", pathFirefox.toString());

        System.setProperty("webdriver.chrome.driver", pathChrome.toString());

        System.setProperty("webdriver.opera.driver", pathOpera.toString());

        System.setProperty("webdriver.edge.driver", pathEdge.toString());
    }

    @BeforeEach
    public void setupEach() {
        System.out.println("BeforeEach");
        switch (System.getProperty("browserFamily")) {
            case firefox: {
                driver = new FirefoxDriver();
                break;
            }
            case chrome: {
                driver = new ChromeDriver();
                break;
            }
            case opera: {
//                OperaOptions options = new OperaOptions();
//                options.addArguments("--no-sandbox");
                driver = new OperaDriver();
                break;
            }
            case edge: {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--no-sandbox");
                driver = new EdgeDriver();
                break;
            }
            default: {
                driver = new FirefoxDriver();
            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
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
