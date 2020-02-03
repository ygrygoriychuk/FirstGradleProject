import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SportPage extends Page {

    @FindBy(how = How.LINK_TEXT, using = "Formula 1")
    public WebElement btnFormula1;

    public SportPage(WebDriver webDriver) {
        super(webDriver);
    }

    public F1Page clickOnFormula1() {
        btnFormula1.click();
        return PageFactory.initElements(webDriver, F1Page.class);
    }
}
