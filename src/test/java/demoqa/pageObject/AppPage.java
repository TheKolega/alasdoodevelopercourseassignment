package demoqa.pageObject;

import localhost.pageObject.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.PageUtils;

import java.util.Map;

public class AppPage extends PageObject<AppPage> {

    private final String pageUrl = "http://demoqa.com/elements";
    private final String pageLoadedText = "Please select an item from left to start practice";
    private final LoadableComponent<DemoQaHomePage> parent;
    private Map<String, String> data;
    private Actions action = new Actions(driver);

    public AppPage(WebDriver driver, LoadableComponent<DemoQaHomePage> parent) {
        super(driver);
        this.parent = parent;
    }

    @Override
    protected void load() {
        parent.get().goToAppPage();
    }

    @Override
    protected void isLoaded() throws Error {
        PageUtils.isLoaded(driver, homePageLogo);
        PageUtils.isLoaded(driver, homePageLogo);
    }

    @FindBy(xpath = "//a[@href='https://demoqa.com']")
    @CacheLookup
    private WebElement homePageLogo;

    //
//    @FindBy(css = ("span[text='Elements'] or span[innertext='Elements']"))
//    @FindBy(css = ("span:contains('^Elements$')"))
    @FindBy(css = ("div:nth-child(1) > span"))
    @CacheLookup
    private WebElement elementsListItem;

    @FindBy(css = ("div:nth-child(2) > span"))
    @CacheLookup
    private WebElement formsListItem;

    @FindBy(css = ("div:nth-child(3) > span"))
    @CacheLookup
    private WebElement alertsListItem;

    @FindBy(css = ("div:nth-child(4) > span"))
    @CacheLookup
    private WebElement widgetsListItem;

    @FindBy(css = ("div:nth-child(5) > span"))
    @CacheLookup
    private WebElement interactionsListItem;

    @FindBy(css = ("div:nth-child(6) > span"))
    @CacheLookup
    private WebElement bookStoreListItem;

    /**
     * Go to the Home page.
     *
     * @return the DemoQaPage class instance
     */
    public DemoQaHomePage goToHomePage() {
        action.moveToElement(homePageLogo).click().perform();
        return new DemoQaHomePage(this.driver);
    }

    /**
     * Click Elements list item.
     *
     * @return the DemoQaPage class instance
     */
    public DemoQaHomePage clickElements() {
        elementsListItem.click();
        return new DemoQaHomePage(this.driver);
    }
}
