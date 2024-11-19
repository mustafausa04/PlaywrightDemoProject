package utils;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PW {


    public static Playwright playwright;
    static Browser browser;
    static Page page;

    public static Page getPage() {
        playwright = Playwright.create();
        String browserType = System.getProperty("browser");
        if (browserType == null) {
            browserType = DataReader.getProperty("browser_type");
        }
        if (page == null ) {
            switch(browserType) {
                case "chrome" :
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
                    break;
                case "firefox" :
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
                    break;
                case "firefox-headless" :
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;
                case "safari" :
                    browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
                    break;
                case "edge" :
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("edge").setHeadless(true));
                    break;
                default:
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                    break;
            }
            page = browser.newPage();
        }
        return page;
    }

    public static void quitPage() {
        if (page != null) {
            playwright.close();
            page = null;
        }

    }
}
