package steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import utils.PW;

public class PlaywrightDemo {

    public static void main(String[] args) {

//        Playwright pw = Playwright.create();
//        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
//        Page page = browser.newPage();
//
//        page.navigate("https://saucedemo.com");
//        String pageTitle = page.title();
//        System.out.println(pageTitle);


        PW.getPage().navigate("https://saucedemo.com");
        String pageTitle = PW.getPage().title();
        System.out.println(pageTitle);
    }
}
