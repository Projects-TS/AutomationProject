package tests.loginTests.negativeTests;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class ValidateLockedUserError {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com");
    }
    @DataProvider(name = "loginDataError")
    public Object[][] loginDataProvider() {
    return new Object[][] {
    {"standard_user", "wrong_password", "Epic sadface: Username and password do not match any user in this service"},
    {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
    {"non_existent_user", "wrong_password", "Epic sadface: Username and password do not match any user in this service"},
    {"", "secret_sauce", "Epic sadface: Username is required"},
    {"standard_user", "", "Epic sadface: Password is required"},
    {"", "", "Epic sadface: Username is required"},};
    }
    @Test(dataProvider = "loginDataError")
    public void testLogin(String username, String password, String expectedErrorMessage) {
    driver.findElement(By.id("user-name")).clear();
    driver.findElement(By.id("user-name")).sendKeys(username);
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("login-button")).click();

    WebElement errorElement = driver.findElement(By.cssSelector(".error-message-container.error"));
    String actualErrorMessage = errorElement.getText();
    Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
    "Actual error message was: '" + actualErrorMessage + "' but expected was: '" + expectedErrorMessage + "'");
    }
    @AfterMethod
    public void tearDown() {
    driver.quit();
    }
    }


