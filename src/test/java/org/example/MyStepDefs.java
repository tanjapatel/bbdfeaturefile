package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {
    Homepage homepage= new Homepage();
    Registerpage registerpage=new Registerpage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    FacebookPage facebookPage= new FacebookPage();
    @Given("I am on registration page")
    public void i_am_on_registration_page() {
        registerpage.userIsOnRegisterPage();

    }
    @When("I enter required filed")
    public void i_enter_required_filed() {
        registerpage.userEnterDetailsForRegistration();

    }
    @When("I click on register button")
    public void i_click_on_register_button() {
        registerpage.userEnterDetailsForRegistration();

    }
    @Then("I able to register successfully")
    public void i_able_to_register_successfully() {
        registerpage.userEnterDetailsForRegistration();
        registrationResultPage.userIsOnRegisterResultPage();

    }
    @Given("I am on homepge")
    public void i_am_on_homepge() {
        homepage.UserIsOnHomePage();

    }
    @When("I click on facebook")
    public void i_click_on_facebook() {
        homepage.UserIsOnHomePage();

    }
    @Then("I able to go to sccessfully on facebook page")
    public void i_able_to_go_to_sccessfully_on_facebook_page() {
        facebookPage.userIsOnFacebookPage();
    }


    @Given("user is on home page")
    public void userIsOnHomePage() {
        homepage.UserIsOnHomePage();

    }

    @When("user clicks all {string}on top header menu")
    public void userClicksAllOnTopHeaderMenu(String category_name) {
        homepage.clickOnCategoryPageLink(category_name);
        
    }

    @Then("page breadcrumbs display {string}on home page")
    public void pageBreadcrumbsDisplayOnHomePage(String category_url) {
        Utils.verifyGetCurrentUrl(category_url);

    }
}
