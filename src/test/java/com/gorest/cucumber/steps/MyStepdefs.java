package com.gorest.cucumber.steps;

import com.gorest.steps.UserSteps;
import com.gorest.utils.PropertyReader;
import com.gorest.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class MyStepdefs {
    static ValidatableResponse response;

    static String token = PropertyReader.getInstance().getProperty("token");
    static String name = "viral" + TestUtils.getRandomValue();
    static String gender = "female";
    static String email = name + "@gmail.com";
    static String status = "active";
    static int newUserId;
    @Steps
    UserSteps usersSteps;
    @When("^User send a GET request to users endpoints$")
    public void userSendAGETRequestToUsersEndpoints() {
        response=usersSteps.getAllUsers();
    }

    @Then("^User must get list of users and valid status code (\\d+)$")
    public void userMustGetListOfUsersAndValidStatusCode(int arg0) {
        response.statusCode(200);
    }

    @When("^I create a new user by providing all the information$")
    public void iCreateANewUserByProvidingAllTheInformation() {
        response=  usersSteps.createUser(name,gender,email,status,token);
        newUserId=response.log().all().extract().path("id");
    }

    @Then("^I verfiy that the new user is created$")
    public void iVerfiyThatTheNewUserIsCreated() {
        usersSteps.getUserByID(newUserId,token);
    }

    @When("^I update a newly created user$")
    public void iUpdateANewlyCreatedUser() {
        name= TestUtils.getRandomString();
        email=TestUtils.getRandomString()+"@gmail.com";
        response = usersSteps.updateUser(name,gender,newUserId,email,status,token);


    }

    @Then("^I verify new user information is updated$")
    public void iVerifyNewUserInformationIsUpdated() {
        response.statusCode(200)
                .body("id",equalTo(newUserId),
                        "name",equalTo(name),
                        "email", equalTo(email),
                        "gender", equalTo(gender), "status",equalTo(status));
    }

    @When("^I delete a newly created user$")
    public void iDeleteANewlyCreatedUser() {
        usersSteps.deleteUser(newUserId,token);
    }

    @Then("^I verify user is deleted$")
    public void iVerifyUserIsDeleted() {
        usersSteps.getUserByID(newUserId,token).statusCode(404);
    }
}
