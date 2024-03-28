package tests.sanityTests;
import org.testng.Assert;
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
        Assert.assertEquals(currentURL, "https://www.saucedemo.com/inventory.html", "URL does not match");

        WebElement productsTitleElement = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String actualProductsText = productsTitleElement.getText();
        Assert.assertEquals(actualProductsText, "Products", "Products title text does not match");

        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket")).click();
        int actualItemNumber = Integer.parseInt(driver.findElement(By.cssSelector("#shopping_cart_container > a")).getText());
        Assert.assertEquals(actualItemNumber, 2, "Cart item count does not match");
        driver.findElement(By.cssSelector("#shopping_cart_container > a")).click();

        String currentURL1 = driver.getCurrentUrl();
        Assert.assertEquals(currentURL1, "https://www.saucedemo.com/cart.html", "URL does not match");

        WebElement cartTitleElement = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String actualCartText = cartTitleElement.getText();
        Assert.assertEquals(actualCartText, "Your Cart", "Your Cart title text does not match");

        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_item"));
        int expectedNumberOfItems = 2;
        Assert.assertEquals(cartItems.size(), expectedNumberOfItems, "Number of items in cart does not match");
        driver.findElement(By.cssSelector("#checkout")).click();

        String currentURL2 = driver.getCurrentUrl();
        Assert.assertEquals(currentURL2,"https://www.saucedemo.com/checkout-step-one.html","URL does not match");

        WebElement checkoutTitleElement = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String actualCheckoutText = checkoutTitleElement.getText();
        Assert.assertEquals(actualCheckoutText, "Checkout: Your Information", "Checkout: Your Information title text does not match");

        driver.findElement(By.cssSelector("#first-name")).sendKeys("Tal");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Shoham");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("755225");
        driver.findElement(By.cssSelector("#continue")).click();

        String currentURL3 = driver.getCurrentUrl();
        Assert.assertEquals(currentURL3, "https://www.saucedemo.com/checkout-step-two.html", "URL does not match");

        WebElement CheckoutOverviewTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String actualCheckoutOverviewText = CheckoutOverviewTitle.getText();
        Assert.assertEquals(actualCheckoutOverviewText, "Checkout: Overview", "Checkout: Overview title text does not match");
        driver.findElement(By.cssSelector("#finish")).click();

        String currentURL4 = driver.getCurrentUrl();
        Assert.assertEquals(currentURL4, "https://www.saucedemo.com/checkout-complete.html", "URL does not match");

        WebElement CheckoutCompleteTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String actualCheckoutCompleteText = CheckoutCompleteTitle.getText();
        Assert.assertEquals(actualCheckoutCompleteText, "Checkout: Complete!", "Checkout: Complete! title text does not match");

        WebElement orderTitle = driver.findElement(By.cssSelector("#checkout_complete_container > h2"));
        String yourOrderText = orderTitle.getText();
        Assert.assertEquals(yourOrderText, "Thank you for your order!", "Thank you for your order title text does not match");

        WebElement dispatchedTitle = driver.findElement(By.cssSelector("#checkout_complete_container > div"));
        String orderDispatchedText = dispatchedTitle.getText();
        Assert.assertEquals(orderDispatchedText,
        "Your order has been dispatched, and will arrive just as fast as the pony can get there!",
        "Dispatched title text does not match");
        }
        @AfterMethod
        public void cleanup() {
        driver.quit();
    }
        }















