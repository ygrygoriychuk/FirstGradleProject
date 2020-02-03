import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {

    @FindBy(how = How.ID, using = "idcta-link")
    public WebElement btnSignIn;

    @FindBy(how = How.CSS, using = "a[href='https://www.bbc.com/sport']")
    public WebElement btnSport;

    @FindBy(how = How.XPATH, using = "//div[@id='orb-panels']//a[.='Reel']")
    public WebElement btnReel;

    @FindBy(how = How.ID, using = "orb-search-button")
    public WebElement btnToolbarSearch;

    @FindBy(how = How.ID, using = "orb-search-q")
    public WebElement txtToolbarSearch;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SportPage clickOnSport() {
        btnSport.click();
        return PageFactory.initElements(webDriver, SportPage.class);
    }
}