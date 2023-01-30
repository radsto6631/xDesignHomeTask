package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.DriverBoss;
import utils.Pages;

import java.time.Duration;

public class HomePageSteps extends Pages {

    @Given("^The page loads$")
    public void thePageLoads() {
        DriverBoss.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Then("^A screen will appear with a list of SpaceX API results$")
    public void aScreenWillAppearWithAListOfSpaceXAPIResults() { homePage.checkIfLaunchListLoaded(); }

    @Given("^Selecting filter$")
    public void selectingFilter() {
        homePage.clickOnYearFilter();
    }

    @When("^Setting filter by year to \"([^\"]*)\"$")
    public void settingFilterByYearTo(String year) {
        homePage.selectYearFromDropdown(year);
    }

    @Then("^Return a list of only launches in \"([^\"]*)\"$")
    public void returnAListOfOnlyLaunchesIn(String year) { homePage.verifyLaunchListItemsAreFromYear(year); }

    @Given("^No year filter is on$")
    public void noYearFilterIsOn() { homePage.verifyFilterIsNotOn();}

    @When("^Ordering is done \"([^\"]*)\"$")
    public void orderingIsDone(String sortBy)  { homePage.setSortingTo(sortBy); }

    @Then("^Items should be ordered alphabetically$")
    public void itemsShouldBeOrderedAlphabetically() { homePage.verifyItemsAreSortedAlphabetically(); }
}
