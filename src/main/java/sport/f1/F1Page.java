package sport.f1;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class F1Page extends AbstractPage {

    @FindBy(how = How.CSS, using = "a[href='https://www.bbc.com/sport/formula1']")
    public WebElement btnFormula1;

    public F1Page(WebDriver webDriver) {
        super(webDriver);
    }

}
