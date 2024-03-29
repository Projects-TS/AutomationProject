package tests.loginTests.negativeTests;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import tests.utils.TestUtils;

public class ValidateLockedUserError {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com");
    }
    @Test(dataProvider = "loginDataError", dataProviderClass = TestUtils.class)
    public void testLogin(String username, String password, String expectedErrorMessage) {
    TestUtils.performLogin(driver, username, password);

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


