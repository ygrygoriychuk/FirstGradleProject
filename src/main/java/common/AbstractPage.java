package common;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver webDriver;

    /*
     * Constructor injecting the WebDriver interface
     * @param webDriver
     */

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public String getTitle() {
        return webDriver.getTitle();
    }
}
