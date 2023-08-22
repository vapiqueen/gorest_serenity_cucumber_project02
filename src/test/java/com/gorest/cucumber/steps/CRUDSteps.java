package com.gorest.cucumber.steps;

import com.gorest.steps.UserSteps;
import com.gorest.utils.PropertyReader;
import com.gorest.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class CRUDSteps {
    static ValidatableResponse response;


    static String token = PropertyReader.getInstance().getProperty("token");
    //static String gender;
    //static String status;
    static int newUserId;
    @Steps
    UserSteps usersSteps;
    @Given("^Gorest application is running$")
    public void gorestApplicationIsRunning() {
    }

    @When("^I create a new user by providing the information name \"([^\"]*)\" gender \"([^\"]*)\" email \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iCreateANewUserByProvidingTheInformationNameGenderEmailStatus(String name, String gender, String email, String status)  {
        response=  usersSteps.createUser(name,gender,email,status,token);

        newUserId=response.log().all().extract().path("id");
    }


    @Then("^I verify that user is created$")
    public void iVerifyThatUserIsCreated() {
        usersSteps.getUserByID(newUserId,token);
    }

    @And("^I update a newly created user and verify user created successfully$")
    public void iUpdateANewlyCreatedUserAndVerifyUserCreatedSuccessfully() {
        String name = TestUtils.getRandomString();
        String email=TestUtils.getRandomString()+"@gmail.com";
        String gender = "female";
        String status = "active";
        usersSteps.updateUser(name,gender,newUserId,email,status,token);

    }

    @And("^I delete a newly created user and verify it deleted successfully$")
    public void iDeleteANewlyCreatedUserAndVerifyItDeletedSuccessfully() {
        usersSteps.deleteUser(newUserId,token);
        usersSteps.getUserByID(newUserId,token).statusCode(404);
    }
}
