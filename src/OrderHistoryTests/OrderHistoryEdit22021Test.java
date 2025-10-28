import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Select;


public class OrderHistoryEdit22021Test {
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
    public void test22021OrderHistory() throws Exception {
        String CUSTOMER_FIRST_NAME = "Anton";
        String CUSTOMER_LAST_NAME = "Ivanov";
        String CUSTOMER_JOB_TITLE = "Manager";
        String CUSTOMER_EMAIL = "test@1234t.com";
        String CUSTOMER_PAYMENTMETHOD = "NET30";
        String CUSTOMER_PRICE_DELIVERY = "50";
        String ALLDISCOUNT = "5";
        String SHIPPING_ADDRESS_1 = "Test 15";
        String SHIPPING_ADDRESS_2 = "Test 10";
        String SHIPPING_SITY = "Sochi";
        String SHIPPING_STATE = "State";
        String SHIPPING_POSTAL_CODE = "2345678";
        String SHIPPING_COUNTRY = "Russia";


        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(2) .nav-item__name")).click();
        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.cssSelector(".tabulator-row:nth-child(1) > .tabulator-cell:nth-child(1) > a")).click();
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
        driver.findElement(By.id("applyBillingAddr")).click();
        driver.findElement(By.id("shipping")).click();
        driver.findElement(By.id("shipping")).sendKeys(String.valueOf(CUSTOMER_PRICE_DELIVERY));
        driver.findElement(By.id("alldiscount_dollars")).clear();
        driver.findElement(By.id("alldiscount_dollars")).sendKeys(String.valueOf(ALLDISCOUNT));
        new Select(driver.findElement(By.name("payment_method"))).selectByVisibleText(CUSTOMER_PAYMENTMETHOD);

        driver.findElement(By.xpath("(//img[@alt='Edit'])[2]")).click();
        driver.findElement(By.id("first_name-field")).clear();
        driver.findElement(By.id("first_name-field")).sendKeys(CUSTOMER_FIRST_NAME);
        driver.findElement(By.id("last_name-field")).clear();
        driver.findElement(By.id("last_name-field")).sendKeys(CUSTOMER_LAST_NAME);
        driver.findElement(By.id("job_title-field")).clear();
        driver.findElement(By.id("job_title-field")).sendKeys(CUSTOMER_JOB_TITLE);
        driver.findElement(By.id("email-field")).clear();
        driver.findElement(By.id("email-field")).sendKeys(CUSTOMER_EMAIL);
        driver.findElement(By.cssSelector(".editing .btn-primary")).click();
        driver.findElement(By.cssSelector(".heading-button")).click();
        try {
            assertEquals(CUSTOMER_PAYMENTMETHOD, driver.findElement(By.cssSelector(".selectable > .btn")).getText());
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
            assertEquals(CUSTOMER_FIRST_NAME, driver.findElement(By.id("first-name")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_LAST_NAME, driver.findElement(By.id("last-name")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_JOB_TITLE, driver.findElement(By.id("customer-job")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_EMAIL, driver.findElement(By.id("customer-email")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }

}

