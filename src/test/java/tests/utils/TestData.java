package tests.utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData {
    // set 1
    @DataProvider(name = "userCredentials")
    public static Object[][] provideUserCredentials() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }

    // set 2
    @DataProvider(name = "loginDataError")
    public static Object[][] provideLoginDataError() {
        return new Object[][]{
                {"standard_user", "wrong_password", "Epic sadface: Username and password do not match any user in this service",},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"non_existent_user", "wrong_password", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"},
        };
    }
    // set 3
    @DataProvider(name = "getURL")
    public static Object[][] URL() {
        return new Object[][]{
                {"https://www.saucedemo.com/"},
        };
    }
}