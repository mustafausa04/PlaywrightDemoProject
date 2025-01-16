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

        //creating an object of the class SaucDemoPage so we can call it in the bottom
        SauceDemoPage saucepage = new SauceDemoPage();

        //playwright is broken down to 3 interfaces (playwright browser engin, browser like chrome, firefox
        //and page)

        //to declare the playwright
        //Playwright pw = Playwright.create();

        //to declare the browser
        //Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));

        //to declare the page
        //Page page = browser.newPage();

        //here we will execute
        //page.navigate("https://saucedemo.com");
        //String pageTitle = page.title();
        //System.out.println(pageTitle);

        //since we created PW class then we don't need to use the above steps anymore
        PW.getPage().navigate("https://saucedemo.com");
        String pageTitle = PW.getPage().title();
        System.out.println(pageTitle);
        System.out.println(PW.getPage().url());

        //we are calling the instance or object of the class SaucDemoPage and then assign the values
        PW.getPage().locator(saucepage.sauceUsername).fill("standard_user");
        PW.getPage().locator(saucepage.saucePassword).fill("secret_sauce");
        PW.getPage().locator(saucepage.sauceLoginBtn).click();

        //to verify that the word (Product) is available
        assertThat(PW.getPage().locator(saucepage.sauceHomePageProductHeader)).isVisible();
    }

}
