package com.DaviesGroup.step_definitions;

import com.DaviesGroup.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class HomeStepDefs {

    HomePage homePage = new HomePage();

    @Given("I open the DaviesGroup webpage")
    public void i_open_the_davies_group_webpage() {
        homePage.setUp();
    }

    @When("I click the social media links")
    public void i_click_the_social_media_links() {
        homePage.switchToWindow();
    }

    @Then("I should be navigate to respective social media webpages")
    public void i_should_be_navigate_to_respective_social_media_webpages(List<String> socialMediaLinks) {
        Assert.assertTrue(homePage.verifyPageTitle(socialMediaLinks));
    }
}
