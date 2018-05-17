import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StepDefinition {

    VisitManager vm;

    @Given("^I GeoLocations at a close distance$")
    public void i_GeoLocations_at_a_close_distance() throws Throwable {
        vm = new VisitManager();
        Assert.assertTrue(vm != null);
    }

    @Then("^I recognize that they are the same point$")
    public void i_recognize_that_they_are_the_same_point() throws Throwable {
        Visit a = new Visit(new GeoLocation(0, 0), "2000/01/01 01:01:01", "2000/01/01 01:01:01");
        Visit b = new Visit(new GeoLocation(0.00001f, 0.00101f), "2000/01/01 01:01:01", "2000/01/01 01:01:01");
        Visit c = new Visit(new GeoLocation(0.0001f, 0.0011f), "2000/01/01 01:01:01", "2000/01/01 01:01:01");
        Visit d = new Visit(new GeoLocation(0.001f, 0.001f), "2000/01/01 01:01:01", "2000/01/01 01:01:01");
        Visit e = new Visit(new GeoLocation(0.01f, 0.01f), "2000/01/01 01:01:01", "2000/01/01 01:01:01");
        vm.findHome(a, b, c, d, e);
        Assert.assertTrue(vm.getKeySet().size() == 3);
    }

    @Given("^I visit a location multiple times$")
    public void i_visit_a_location_multiple_times() throws Throwable {
        vm = new VisitManager();
        Visit[] temp = {new Visit(new GeoLocation(0, 0), "2000/01/01 01:01:01", "2000/01/01 01:01:01")
                , new Visit(new GeoLocation(0.00001f, 0.00001f), "2000/01/03 01:01:01", "2000/01/03 01:01:01")
                , new Visit(new GeoLocation(0.0001f, 0.0001f), "2000/01/04 01:01:01", "2000/01/04 01:01:01")};
        vm.findHome(temp);
        Assert.assertTrue((1 == vm.getKeySet().size()));
    }

    @Then("^I correctly add up all the cumulative time spent there$")
    public void i_correctly_add_up_all_the_cumulative_time_spent_there() throws Throwable {
        vm = new VisitManager();
        Visit[] temp = {new Visit(new GeoLocation(0, 0), "2000/01/02 01:01:01", "2000/01/02 02:01:01")
                , new Visit(new GeoLocation(0.00001f, 0.00001f), "2000/01/03 01:01:01", "2000/01/03 03:01:01")
                , new Visit(new GeoLocation(0.0001f, 0.0001f), "2000/01/04 01:01:01", "2000/01/04 04:01:01")};
        vm.findHome(temp);
        long time = vm.getHighestValue();
        final int sec = (int) (time / 1000), d = sec / 86400, h = sec / 3600 % 24, m = sec / 60 % 60, s = sec % 60;
        Assert.assertEquals(6, h);
    }


    @Given("^I have a night time value$")
    public void i_have_a_night_time_value() throws Throwable {
        Assert.assertTrue(true);
    }

    @Then("^Identify that it is valid$")
    public void identify_that_it_is_valid() throws Throwable {
        vm = new VisitManager();
        Date start = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2000/01/02 19:01:01");
        Date end = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2000/01/02 09:01:01");
        Date badvalue = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2000/01/02 10:01:01");
        Date badvalue1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2000/01/02 11:01:01");
        Date pass = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2000/01/02 21:01:01");
        Date pass1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2000/01/02 01:01:01");
        vm.locationAtNight(end,start);
        vm.locationAtNight(badvalue,badvalue1);
        vm.locationAtNight(pass,pass1);
    }

}
