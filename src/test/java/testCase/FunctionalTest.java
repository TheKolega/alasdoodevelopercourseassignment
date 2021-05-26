package testCase;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.PageObject;
import utils.BrowsersEnum;
import utils.ConstEnum;

import java.util.concurrent.TimeUnit;


/**
 * <strong>testCase.FunctionalTest</strong> handles setup and teardown of WebDriver.
 *
 * @author Milos
 */
public class FunctionalTest {

    protected WebDriver driver;
    public static BrowsersEnum BROWSER = BrowsersEnum.EDGE;

    @RegisterExtension
    static SeleniumJupiter seleniumJupiter = new SeleniumJupiter();

    @BeforeAll
    public static void setupAll() {
        System.out.println("BeforeAll");

//        System.setProperty("browserFamily", "phantomjs"); //! Maven command input

        BROWSER = getBrowserTypeProperty(System.getProperty("browserFamily"));
        seleniumJupiter.getConfig().setDefaultBrowser(BROWSER.getStringValue());
    }

    @BeforeEach
    public void setupEach(WebDriver driver) {
        System.out.println("BeforeEach");

        this.driver = driver;
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(ConstEnum.LOAD_TIMEOUT.getValue(), TimeUnit.SECONDS);
//        driver.manage().window().maximize();


/*        WebDriverManager browser selection - deprecated
//
//        switch (System.getProperty("browserFamily")) {
//            case firefox: {
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            }
//            case chrome: {
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                break;
//            }
//            case opera: {
//                OperaOptions options = new OperaOptions();
//                options.addArguments("--no-sandbox");
//                WebDriverManager.operadriver().setup();
//                driver = new OperaDriver(options);
//                break;
//            }
//            case edge: {
//                EdgeOptions options = new EdgeOptions();
//                options.addArguments("--no-sandbox");
//                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver(options);
//                break;
//            }
//            default: {
//                System.setProperty("browserFamily", firefox);
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            }
//        }
 */
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

    private static BrowsersEnum getBrowserTypeProperty(String browserProperty)
            throws IllegalArgumentException {
        if (browserProperty == null || browserProperty.isEmpty()) {
//            logger.info("Browser was null. Setting chrome as browser.");
            return BrowsersEnum.CHROME;
        }
        BrowsersEnum browser = BrowsersEnum.valueOf(browserProperty.toUpperCase());
//        logger.info("Browser identified: {},", browser);
        return browser;
    }

    public WebElement seekTillLastPage(PageObject<?> page, String expectedValue) {
        boolean lastPage = false;
        WebElement foundElement = null;
        WebElement nextPageButton = null;
        // Because the add button covers the next page, click it to move it
        driver.findElement(By.xpath("//button[@aria-label='add']")).click();
        while (!lastPage) {
            nextPageButton = driver.findElement(By.xpath("//div[@class='MuiTablePagination-actions']//button[@title='Next page']"));
            if (nextPageButton.getAttribute("tabindex").equals("-1")) {
                // by tabindex="-1" or by disabled=""
                lastPage = true;
            }
            //find element with expectedValue on current page
            try {
                return foundElement = driver.findElement(By.xpath("//div[@data-value='" + expectedValue + "']"));
            } catch (NoSuchElementException ex) {
                if (lastPage) {
                    break;
                } else {
                    driver.findElement(By.xpath("//button[@aria-label='add']")).click();
                    nextPageButton.click();
                }
            }
        }
        return foundElement;
    }

}
