package utils;


import com.microsoft.playwright.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PW {

    //hre we will create a pw driver and compare it to Driver class that we used to create from before
    public static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    static Page page;

    //replace the Driver with Page
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
            context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
            page = context.newPage();
        }
        return page;
    }

    public static void closePage() {
        if (page != null) {
            context.close();
            page = null;
        }
    }

    public static void closePlaywright(){
        playwright.close();
    }
}
