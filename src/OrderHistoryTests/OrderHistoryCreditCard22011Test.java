import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderHistoryCreditCard22011Test {
    private WebDriver driver;
    private StringBuffer verificationErrors = BufferHelper.getNewBuffer();
    JavascriptExecutor js;
    @Rule
    public ScreenshotTestRule screenshotRule = new ScreenshotTestRule();

    @Before
    public void setUp() throws Exception {
        driver = Cfg.getDriver();
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void test22011OrderHistoryCreditCard() throws Exception {
        String COMPANY_NAME = "testtest";
        String CUSTOMER_PAYMENTMETHOD = "Credit card";
        String CUSTOMER_PRODUCT_1 = "Ordered product";
        String CUSTOMER_PRICE_PRODUCT_1 = "20";
        String CUSTOMER_COUNT_PRODUCT_1 = "15";
        String CUSTOMER_DISCOUNT_PCT_PRODUCT_1 = "30";
        String CUSTOMER_PRODUCT_2 = "Removable product";
        String CUSTOMER_PRICE_PRODUCT_2 = "30";
        String CUSTOMER_COUNT_PRODUCT_2 = "15";
        String CUSTOMER_DISCOUNT_PCT_PRODUCT_2 = "20";
        String CUSTOMER_PRICE_DELIVERY = "50";
        String ALLDISCOUNT = "15";
        String SHIPPING_ADDRESS_1 = "Lenina 1";
        String SHIPPING_ADDRESS_2 = "Test 10";
        String SHIPPING_SITY = "Moscow";
        String SHIPPING_STATE = "State";
        String SHIPPING_POSTAL_CODE = "1234567";
        String SHIPPING_COUNTRY = "Russia";
        String BILLING_ADDRESS_1 = "Lenina 28";
        String BILLING_ADDRESS_2 = "Test 88";
        String BILLING_SITY = "Orsk";
        String BILLING_STATE = "State";
        String BILLING_POSTAL_CODE = "7654321";
        String BILLING_COUNTRY = "Russia";

        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(2) .nav-item__name")).click();
        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.cssSelector(".btn-bright")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        assertEquals("Place new order", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.cssSelector(".show > .bs-searchbox > .form-control")).sendKeys(COMPANY_NAME);
        driver.findElement(By.cssSelector(".bs-searchbox > .form-control")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.xpath("(//img[@alt='Edit'])[3]")).click();
        driver.findElement(By.id("shipping-address-field")).clear();
        driver.findElement(By.id("shipping-address-field")).sendKeys(SHIPPING_ADDRESS_1);
        driver.findElement(By.id("shipping-address-2-field")).clear();
        driver.findElement(By.id("shipping-address-2-field")).sendKeys(SHIPPING_ADDRESS_2);
        driver.findElement(By.id("shipping-city-field")).clear();
        driver.findElement(By.id("shipping-city-field")).sendKeys(SHIPPING_SITY);
        driver.findElement(By.id("shipping-state-field")).clear();
        driver.findElement(By.id("shipping-state-field")).sendKeys(SHIPPING_STATE);
        driver.findElement(By.id("shipping-postal-code-field")).clear();
        driver.findElement(By.id("shipping-postal-code-field")).sendKeys(SHIPPING_POSTAL_CODE);
        driver.findElement(By.id("shipping-country-field")).clear();
        driver.findElement(By.id("shipping-country-field")).sendKeys(SHIPPING_COUNTRY);
        driver.findElement(By.cssSelector(".editing .btn-primary")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("(//img[@alt='Edit'])[4]")).click();
        if (!driver.findElement(By.id("billing_address_same_as_shipping")).isSelected()) {
            driver.findElement(By.cssSelector(".input-label")).click();
        } else {
            driver.findElement(By.cssSelector(".input-label")).click();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.findElement(By.cssSelector(".product_item_select .filter-option-inner-inner")).click();
        driver.findElement(By.cssSelector(".show .form-control")).sendKeys(CUSTOMER_PRODUCT_1, Keys.ENTER);
        driver.findElement(By.name("price[]")).clear();
        driver.findElement(By.name("price[]")).sendKeys(CUSTOMER_PRICE_PRODUCT_1);
        driver.findElement(By.name("quantity[]")).clear();
        driver.findElement(By.name("quantity[]")).sendKeys(CUSTOMER_COUNT_PRODUCT_1);
        driver.findElement(By.name("discount[]")).clear();
        driver.findElement(By.name("discount[]")).sendKeys(CUSTOMER_DISCOUNT_PCT_PRODUCT_1);

        driver.findElement(By.cssSelector(".bs-placeholder .filter-option-inner-inner")).click();
        driver.findElement(By.cssSelector(".show .form-control")).sendKeys(CUSTOMER_PRODUCT_2, Keys.ENTER);
        driver.findElement(By.xpath("//tr[2]/td[5]/div/input")).sendKeys(CUSTOMER_PRICE_PRODUCT_2);
        driver.findElement(By.xpath("//tr[2]/td[6]/div/input")).clear();
        driver.findElement(By.xpath("//tr[2]/td[6]/div/input")).sendKeys(CUSTOMER_COUNT_PRODUCT_2);
        driver.findElement(By.xpath("//tr[2]/td[7]/table/tbody/tr/td[2]/div/div/input")).clear();
        driver.findElement(By.xpath("//tr[2]/td[7]/table/tbody/tr/td[2]/div/div/input")).sendKeys(CUSTOMER_DISCOUNT_PCT_PRODUCT_2);
        driver.findElement(By.id("shipping")).clear();
        driver.findElement(By.id("shipping")).sendKeys(String.valueOf(CUSTOMER_PRICE_DELIVERY));
        driver.findElement(By.id("alldiscount_dollars")).clear();
        driver.findElement(By.id("alldiscount_dollars")).sendKeys(String.valueOf(ALLDISCOUNT));
        Select payment_method = new Select(driver.findElement(By.name("payment_method")));
        payment_method.selectByVisibleText(CUSTOMER_PAYMENTMETHOD);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        driver.findElement(By.cssSelector(".heading-button")).click();


        Thread.sleep(5000);
        try {
            assertEquals(CUSTOMER_PAYMENTMETHOD, driver.findElement(By.cssSelector(".selectable .filter-option-inner-inner")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        try {
            assertEquals(CUSTOMER_PRODUCT_1, driver.findElement(By.cssSelector(".product_item_select .filter-option-inner-inner")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_PRODUCT_2, driver.findElement(By.cssSelector(".product-item-row:nth-child(2) .btn")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(SHIPPING_ADDRESS_1, driver.findElement(By.id("customer-shipping-address")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(SHIPPING_ADDRESS_2, driver.findElement(By.id("customer-shipping-address-2")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(SHIPPING_SITY, driver.findElement(By.id("customer-shipping-city")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(SHIPPING_STATE, driver.findElement(By.id("customer-shipping-state")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(SHIPPING_POSTAL_CODE, driver.findElement(By.id("customer-shipping-postal-code")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(SHIPPING_COUNTRY, driver.findElement(By.id("customer-shipping-country")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(BILLING_ADDRESS_1, driver.findElement(By.id("customer-billing-address")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(BILLING_ADDRESS_2, driver.findElement(By.id("customer-billing-address-2")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(BILLING_SITY, driver.findElement(By.id("customer-billing-city")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(BILLING_STATE, driver.findElement(By.id("customer-billing-state")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(BILLING_POSTAL_CODE, driver.findElement(By.id("customer-billing-postal-code")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(BILLING_COUNTRY, driver.findElement(By.id("customer-billing-country")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

    }


}

