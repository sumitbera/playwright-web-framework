package utility;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;

public class BaseTest implements AppConstants.BROWSERS, AppConstants.APP_PARAMETERS {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initBrowser(String browserName) {
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case CHROMIUM:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
                break;
            case FIREFOX:
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
                break;
            case SAFARI:
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
                break;
            case CHROME:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
                break;
            default:
                if (browser == null) {
                    throw new IllegalArgumentException("Could not launch a browser for type " + browserName);
                }
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(BASE_URL);
        return page;
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
}
