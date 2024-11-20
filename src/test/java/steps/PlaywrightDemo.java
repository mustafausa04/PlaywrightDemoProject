package steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;
import pages.SauceDemoPage;
import utils.PW;

public class PlaywrightDemo {

    public static void main(String[] args) {

        SauceDemoPage saucepage = new SauceDemoPage();

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
        System.out.println(PW.getPage().url());

        PW.getPage().locator(saucepage.sauceUsername).fill("standard_user");
        PW.getPage().locator(saucepage.saucePassword).fill("secret_sauce");
        PW.getPage().locator(saucepage.sauceLoginBtn).click();

        assertThat(PW.getPage().locator(saucepage.sauceHomePageProductHeader)).isVisible();

    }
}
