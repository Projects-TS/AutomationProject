package tests.loginTests.positiveTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

public class ValidateStandardUserLogin {
        private WebDriver driver;
        @BeforeMethod
        public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        }
        @DataProvider(name = "userCredentials")
        public Object[][] provideUserCredentials() {
        return new Object[][]{
        {"standard_user", "secret_sauce"},
        {"problem_user", "secret_sauce"},
        {"performance_glitch_user", "secret_sauce"},
        {"error_user", "secret_sauce"},
        {"visual_user", "secret_sauce"}};
        }
        @Test(dataProvider = "userCredentials")
        public void testLoginAndProductSelection(String username, String password) {
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.saucedemo.com/inventory.html", "URL does not match");

        WebElement productsTitleElement = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String actualProductsText = productsTitleElement.getText();
        Assert.assertEquals(actualProductsText, "Products", "Products title text does not match");
        }
        @AfterMethod
        public void tearDownMethod() {
        if (driver != null) {
        driver.quit();}
        }
        }









