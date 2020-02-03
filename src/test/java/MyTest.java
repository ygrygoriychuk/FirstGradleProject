import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyTest {
    public MainPage mainPage;
    public SportPage sportPage;
    WebDriver webDriver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:/EclipseJARs/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get("https://www.bbc.com/");
        mainPage = PageFactory.initElements(webDriver, MainPage.class);
    }

    @AfterEach
    public void tearDown() throws Exception {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    @Test
    public void test() {
        Assertions.assertEquals("webDriver", "webDriver");
        Assertions.assertEquals("Search", mainPage.txtToolbarSearch.getAttribute("placeholder"));
        Assertions.assertTrue(mainPage.btnToolbarSearch.isDisplayed());
        Assertions.assertTrue(mainPage.btnSignIn.isDisplayed());

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(mainPage.btnSport));
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.btnSport));
        SportPage sportPage = mainPage.clickOnSport();
        System.out.println(sportPage.getTitle());
        wait.until(ExpectedConditions.elementToBeClickable(sportPage.btnFormula1));

        Assertions.assertEquals("Home - BBC Sport", sportPage.getTitle());

        F1Page f1Page = sportPage.clickOnFormula1();
        wait.until(ExpectedConditions.titleIs("Formula 1 - BBC Sport"));

        Assertions.assertEquals("Formula 1 - BBC Sport", f1Page.getTitle());

        System.out.println(f1Page.getTitle());
    }

}
