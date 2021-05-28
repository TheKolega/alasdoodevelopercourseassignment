package demoqa.pageObject;

import localhost.pageObject.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utils.PageUtils;

import java.util.Map;

public class DemoQaHomePage extends PageObject<DemoQaHomePage> {

    private final String pageUrl = "http://demoqa.com";
    private final String pageLoadedText = "";
    private Map<String, String> data;
    private Actions action = new Actions(driver);

    public DemoQaHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {
        this.driver.get(pageUrl);
    }

    @Override
    protected void isLoaded() throws Error {
        PageUtils.isLoaded(driver, homePageLogo);
        PageUtils.isLoaded(driver, elementsCard);
    }

    @FindBy(xpath = "//a[@href='https://demoqa.com']")
    @CacheLookup
    private WebElement homePageLogo;

    @FindBy(xpath = ("//h5[contains(text(),'Elements')]"))
    @CacheLookup
    private WebElement elementsCard;

    @FindBy(xpath = ("//h5[contains(text(),'Forms')]"))
    @CacheLookup
    private WebElement formsCard;

    @FindBy(xpath = ("//h5[contains(text(),'Alerts, Frame')]"))
    @CacheLookup
    private WebElement alertsCard;

    @FindBy(xpath = ("//h5[contains(text(),'Widgets')]"))
    @CacheLookup
    private WebElement widgetsCard;

    @FindBy(xpath = ("//h5[contains(text(),'Interactions')]"))
    @CacheLookup
    private WebElement interactionsCard;

    @FindBy(xpath = ("//div/div/div/h5[contains(text(),'Book Store')]"))
    @CacheLookup
    private WebElement bookStoreAppCard;

    /**
     * Move to the Home Page logo.
     *
     * @return the DemoQaPage class instance.
     */
    public DemoQaHomePage moveToHomePageLogo() {
        action.moveToElement(homePageLogo).perform();
        return this;
    }

    /**
     * Move to the Home Page logo and click.
     *
     * @return the DemoQaPage class instance.
     */
    public DemoQaHomePage clickHomePageLogo() {
        action.moveToElement(homePageLogo).click().perform();
        return this;
    }

    /**
     * Move to the Elements card.
     *
     * @return the DemoQaPage class instance.
     */
    public DemoQaHomePage moveToElementsCard() {
        action.moveToElement(elementsCard).perform();
        return this;
    }

    /**
     * Move to the Forms card.
     *
     * @return the DemoQaPage class instance.
     */
    public DemoQaHomePage moveToFormsCard() {
        action.moveToElement(formsCard).perform();
        return this;
    }

    /**
     * Move to the Alerts Frame & Windows card.
     *
     * @return the DemoQaPage class instance.
     */
    public DemoQaHomePage moveToAlertsCard() {
        action.moveToElement(alertsCard).perform();
        return this;
    }

    /**
     * Move to the Interactions card.
     *
     * @return the DemoQaPage class instance.
     */
    public DemoQaHomePage moveToInteractionsCard() {
        action.moveToElement(interactionsCard).perform();
        return this;
    }

    /**
     * Move to the Book Store card.
     *
     * @return the DemoQaPage class instance.
     */
    public DemoQaHomePage moveToBookStoreCard() {
        action.moveToElement(bookStoreAppCard).perform();
        return this;
    }

    /**
     * Go to the App page.
     *
     * @return the DemoQaPage class instance
     */
    public AppPage goToAppPage() {
        action.moveToElement(elementsCard).click().perform();
        return new AppPage(this.driver, this);
    }
}
