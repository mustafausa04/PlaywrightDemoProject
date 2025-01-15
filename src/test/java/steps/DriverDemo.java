package steps;

import utils.Driver;

public class DriverDemo {


    public static void main(String[] args) {
        //this is what we usually do in our previous frame works just to compare it with the PlaywrightDemo
        Driver.getDriver().get("https://saucedemo.com");
        String homepagetitle = Driver.getDriver().getTitle();
        System.out.println(homepagetitle);
    }

}
