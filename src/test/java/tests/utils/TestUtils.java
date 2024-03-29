package tests.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class TestUtils {
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
        {"standard_user", "wrong_password", "Epic sadface: Username and password do not match any user in this service"},
        {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
        {"non_existent_user", "wrong_password", "Epic sadface: Username and password do not match any user in this service"},
        {"", "secret_sauce", "Epic sadface: Username is required"},
        {"standard_user", "", "Epic sadface: Password is required"},
        {"", "", "Epic sadface: Username is required"},
        };
    }
    // set 3
    public static void performLogin(WebDriver driver, String username, String password) {
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
    }



