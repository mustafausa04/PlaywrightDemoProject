package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.junit.Before;
import utils.PW;

public class Hooks {


    @After
    public void aftereach(Scenario scenario) {
        if (scenario.isFailed()) {
           final byte[] screenshot = PW.getPage().screenshot();
           scenario.attach(screenshot, "image/png", "screenshot");
        }
        PW.closePage();
    }

    @AfterAll
    public static void afterAll() {
        PW.closePlaywright();
    }


}
