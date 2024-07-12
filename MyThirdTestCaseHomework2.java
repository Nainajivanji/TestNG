package SeleniumTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Write a test script for below happy flow:
1. Go to demo.nopcommerce.com
2. Select Computer >> Desktop >> Lenova IdeaCentre 600 All-in-One PC.
3. Add to cart – quantity 1. Verify it has been added to cart.
4. Go to Shopping Cart and update quantity to 3.
5. Agree terms and conditions and go to checkout.
6  Checkout as Guest
7. Fill billing information (click ship to the same address)
8. Fill shipping method
9. Payment method
10.Payment information (enter incorrect details)
 */
public class MyThirdTestCaseHomework2 {
    WebDriver driver;
    WebDriverWait wait;

    //Go to demo.nopcommerce.com
    @BeforeClass
    public void openBrowser() {
        System.out.println("Open Browser");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void closeBrowser() {
        System.out.println("Close Browser");
        driver.quit();
    }

    // Select Computer >> Desktop >> Lenova IdeaCentre 600
    @Test(priority = 1)
    public void SelectComputer() {
        System.out.println("1. Select Computer");

        driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(1) > a")).click();
        //Select Desktop
        driver.findElement(By.cssSelector("#main > div > div.side-2 > div.block.block-category-navigation > div.listbox > ul > li.active.last > ul > li:nth-child(1) > a")).click();
        //Select Lenova IdeaCentre 600
        driver.findElement(By.cssSelector("#main > div > div.center-2 > div > div.page-body > div.products-container > div.products-wrapper > div > div > div:nth-child(3) > div > div.details > h2 > a")).click();
        //  Add to cart – quantity 1
    }

    @Test(priority = 2)
    public void AddToCart() {
        System.out.println("2. Add to Cart");
        driver.findElement(By.id("add-to-cart-button-3")).sendKeys("1");
        // driver.findElement(By.id("product_enteredQuantity_3")).sendKeys("1");
        driver.findElement(By.id("add-to-cart-button-3")).click();
        //Verify it has been added to cart
    }

    @Test(priority = 3)
    public void VerifyItemAdded() {
        System.out.println("3. Verify added to Cart");
        driver.findElement(By.className("cart-label")).click();

    }

    //Go to Shopping Cart and update quantity to 3
    // driver.findElement(By.className("quantity"));
    //driver.findElement(By.id("quantity-up-11231")).click();

    //Agree terms and conditions and go to checkout
    @Test(priority = 4)
    public void AgreeToTandC() {
        System.out.println("4. Agree to Terms and Conditions");
        driver.findElement(By.id("termsofservice")).click();
    }

    //Checkout
    @Test(priority = 5)
    public void Checkout() {
        System.out.println("5. Checkout");
        driver.findElement(By.id("checkout")).click();
    }

    //Checkout as Guest
    @Test(priority = 6)
    public void CheckOutAsGuest() {
        System.out.println("6. Checkout as Guest");
        driver.findElement(By.cssSelector("#main > div > div > div > div.page-body > div.customer-blocks > div.new-wrapper.checkout-as-guest-or-register-block > div.buttons > button.button-1.checkout-as-guest-button")).click();
    }

    //Fill billing information (click ship to the same address)
    @Test(priority = 7)
    public void FillBillingInformation() {
        System.out.println("7. Fill in Billing information");
       // driver.findElement(By.id("CreditCardType")).sendKeys("Visa");
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Jane");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Doe");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("JaneDoe123!@gmail.com");
        driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("Glaxo Smith");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("57 Bartholomew Close, London");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("EC1A 7ES");
        driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("United Kingdom");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("07876528971");
        driver.findElement(By.cssSelector("#billing-buttons-container > button.button-1.new-address-next-step-button")).click();
    }

    // Fill shipping method
    @Test(priority = 8)
    public void FillShippingInformation() throws InterruptedException {
       System.out.println("8. Fill Shipping Method");
        Thread.sleep(3000);
       driver.findElement(By.cssSelector("#shipping-method-buttons-container > button")).click();
    }

    // Payment method
    @Test(priority = 9)
    public void PaymentMethod() throws InterruptedException {
        System.out.println("9. Payment Method");
        Thread.sleep(3000);
        driver.findElement(By.id("paymentmethod_1")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
        //driver.findElement(By.id("paymentmethod_1")).click();
        //driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
        //driver.findElement(By.cssSelector("#shipping-method-buttons-container > button"));


    }
    // Payment information (enter incorrect details)
    @Test(priority = 10)
    public void PaymentInformation() throws InterruptedException {
        System.out.println("10. Payment information");

        Thread.sleep(3000);
        //driver.findElement(By.id("CreditCardType")).sendKeys("Visa");
        driver.findElement(By.cssSelector("#CardholderName")).sendKeys("Ms Jane Doe");
        driver.findElement(By.id("CardNumber")).sendKeys("3456912098237846");
        driver.findElement(By.id("ExpireMonth")).sendKeys("09");
        driver.findElement(By.id("ExpireYear")).sendKeys("2028");
        driver.findElement(By.id("CardCode")).sendKeys("918");
        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button")).click();
        //driver.findElement(By.xpath("//*[@id=\"checkout-payment-info-load\"]/div/div/div[2]/ul/li"));
        System.out.println("Wrong card number");
    }
}

