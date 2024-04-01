package tests.loginTests.positiveTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import tests.utils.TestData;
import tests.utils.TestUtils;

public class ValidateStandardUserLogin {
        private WebDriver driver;
        @BeforeMethod
        public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        }
        @Test(dataProvider = "userCredentials", dataProviderClass = TestData.class)
        public void testLoginAndProductSelection(String username, String password) {
        TestUtils.performLogin(driver, username, password);

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









