package tests.sanityTests;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.List;

public class BuyProductsScenario {
        private WebDriver driver;
        @BeforeSuite
        public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");}

        @Test (testName = "productsScenario")
        public void testLoginAndProductSelection() {
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("URL does not match", "https://www.saucedemo.com/inventory.html", currentURL);

        WebElement productsTitleElement = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String actualProductsText = productsTitleElement.getText();
        Assert.assertEquals("Products title text does not match", "Products", actualProductsText);

        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket")).click();
        int actualItemNumber = Integer.parseInt(driver.findElement(By.cssSelector("#shopping_cart_container > a")).getText());
        Assert.assertEquals("Cart item count does not match", 2, actualItemNumber);
        driver.findElement(By.cssSelector("#shopping_cart_container > a")).click();

        String currentURL1 = driver.getCurrentUrl();
        Assert.assertEquals("URL does not match", "https://www.saucedemo.com/cart.html", currentURL1);

        WebElement cartTitleElement = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String actualcartText = cartTitleElement.getText();
        Assert.assertEquals("Your Cart title text does not match", "Your Cart", actualcartText);

        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_item"));
        int expectedNumberOfItems = 2;
        Assert.assertEquals("Number of items in cart does not match", expectedNumberOfItems, cartItems.size());
        driver.findElement(By.cssSelector("#checkout")).click();

        String currentURL2 = driver.getCurrentUrl();
        Assert.assertEquals("URL does not match", "https://www.saucedemo.com/checkout-step-one.html", currentURL2);

        WebElement checkoutTitleElement = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String actualcheckoutText = checkoutTitleElement.getText();
        Assert.assertEquals("Checkout: Your Information title text does not match", "Checkout: Your Information", actualcheckoutText);

        driver.findElement(By.cssSelector("#first-name")).sendKeys("Tal");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Shoham");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("755225");
        driver.findElement(By.cssSelector("#continue")).click();

        String currentURL3 = driver.getCurrentUrl();
        Assert.assertEquals("URL does not match", "https://www.saucedemo.com/checkout-step-two.html", currentURL3);

        WebElement CheckoutOverviewTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String actualCheckoutOverviewText = CheckoutOverviewTitle.getText();
        Assert.assertEquals("Checkout: Overview title text does not match", "Checkout: Overview", actualCheckoutOverviewText);
        driver.findElement(By.cssSelector("#finish")).click();

        String currentURL4 = driver.getCurrentUrl();
        Assert.assertEquals("URL does not match", "https://www.saucedemo.com/checkout-complete.html", currentURL4);

        WebElement CheckoutCompleteTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String actualCheckoutCompleteText = CheckoutCompleteTitle.getText();
        Assert.assertEquals("Checkout: Complete! title text does not match", "Checkout: Complete!", actualCheckoutCompleteText);

        WebElement orderTitle = driver.findElement(By.cssSelector("#checkout_complete_container > h2"));
        String yourorderText = orderTitle.getText();
        Assert.assertEquals("thank you for your order title text does not match", "Thank you for your order!", yourorderText);

        WebElement dispatchedTitle = driver.findElement(By.cssSelector("#checkout_complete_container > div"));
        String orderdispatchedText = dispatchedTitle.getText();
        Assert.assertEquals("dispatched title text does not match",
        "Your order has been dispatched, and will arrive just as fast as the pony can get there!", orderdispatchedText);
        }
        @AfterMethod
        public void cleanup() {
        driver.quit();
    }
        }

