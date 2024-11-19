package steps;

import utils.Driver;

public class DriverDemo {


    public static void main(String[] args) {
        Driver.getDriver().get("https://saucedemo.com");
        String homepagetitle = Driver.getDriver().getTitle();
        System.out.println(homepagetitle);
    }
}
