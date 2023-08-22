package com.gorest.userinfo;

import com.gorest.steps.UserSteps;
import com.gorest.testbase.TestBase;
import com.gorest.utils.PropertyReader;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

public class UserDataDrivenTest extends TestBase {
    private String  name;
    private String gender;
    private String email;

    private String status;
    static  String token= PropertyReader.getInstance().getProperty("token");


    @Steps
    UserSteps usersSteps;

    @Title("Data driven test for adding multiple users to the application")
    @Test
    public void createMultipleUsers(){
        usersSteps.createUser(name,gender,email,status,token).statusCode(201);
    }
}
