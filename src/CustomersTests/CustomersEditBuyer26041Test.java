import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class CustomersEditBuyer26041Test {
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
    public void test26041CustomersBuyer() throws Exception {
        //
        String CUSTOMER_PAYMENT_METHOD = "Card";
        String CUSTOMER_COMPANY_NAME = "Test Buyer";
        String CUSTOMER_EMAIL = Cfg.getSaltString();
        String CUSTOMER_STATUS = "Not active";
        String CUSTOMER_TYPE = "Buyer";
        String CUSTOMER_PRICE_TYPE = "Wholesale";
        String CUSTOMER_TAX_STATUS = "Exempt";
        String CUSTOMER_REP = "Test Rep";
        String CUSTOMER_TAX_NUMBER = "881-882-99-00";
        String CUSTOMER_FIRST_NAME = "Mike";
        String CUSTOMER_LAST_NAME = "Pavelsky";
        String CUSTOMER_JOB_TITLE = "Buyer";
        String CUSTOMER_MOBILE = "+7 (913) 888-98-11";
        String CUSTOMER_PHONE = "44-22-12";
        String CUSTOMER_FAX = "646-12-1234567890";
        String CUSTOMER_WEBSITE = "https://google.com/";
        int CUSTOMER_BILLING_ADDRESS_REQ = 1;
        String CUSTOMER_BILL_ADDRESS_1 = "Svododi 41";
        String CUSTOMER_BILL_ADDRESS_2 = "17";
        String CUSTOMER_BILL_CITY = "Orenburg";
        String CUSTOMER_BILL_REGION = "South Russia";
        String CUSTOMER_BILL_POSTAL_CODE = "462200";
        String CUSTOMER_BILL_COUNTRY = "Russia";
        String CUSTOMER_SHIP_ADDRESS_1 = "Svododi 43";
        String CUSTOMER_SHIP_ADDRESS_2 = "17";
        String CUSTOMER_SHIP_CITY = "Orsk";
        String CUSTOMER_SHIP_REGION = "North Russia";
        String CUSTOMER_SHIP_POSTAL_CODE = "462419";
        String CUSTOMER_SHIP_COUNTRY = "Russia";
        //

        driver.get(Cfg.getSiteLink() + "/logout/");

        //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        //
        Cfg.Authorization();
        //
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(5) .nav-item__img")).click();
        assertEquals("Customers", driver.findElement(By.xpath("//div[2]/h1")).getText());
        Select type = new Select(driver.findElement(By.name("type")));
        type.selectByVisibleText("Buyer");
        driver.findElement(By.cssSelector(".field > .btn")).click();
        driver.findElement(By.cssSelector(".tabulator-row:nth-child(1) > .tabulator-cell:nth-child(1) > a")).click();
        assertEquals("test - Update customer", driver.getTitle());
        driver.findElement(By.name("company_name")).clear();
        driver.findElement(By.name("company_name")).sendKeys(CUSTOMER_COMPANY_NAME);
        //
        new Select(driver.findElement(By.id("status-field"))).selectByVisibleText(CUSTOMER_STATUS);
        new Select(driver.findElement(By.id("type_field"))).selectByVisibleText(CUSTOMER_TYPE);
        new Select(driver.findElement(By.id("price-type-field"))).selectByVisibleText(CUSTOMER_PRICE_TYPE);
        new Select(driver.findElement(By.name("tax_status"))).selectByVisibleText(CUSTOMER_TAX_STATUS);
        new Select(driver.findElement(By.id("allowed-payment-methods"))).selectByVisibleText(CUSTOMER_PAYMENT_METHOD);
        //
        //
        driver.findElement(By.xpath("//img[@alt='Edit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(CUSTOMER_EMAIL);
        driver.findElement(By.name("tax_number")).clear();
        driver.findElement(By.name("tax_number")).sendKeys(CUSTOMER_TAX_NUMBER);
        driver.findElement(By.name("first_name")).clear();
        driver.findElement(By.name("first_name")).sendKeys(CUSTOMER_FIRST_NAME);
        driver.findElement(By.name("last_name")).clear();
        driver.findElement(By.name("last_name")).sendKeys(CUSTOMER_LAST_NAME);
        driver.findElement(By.name("job_title")).clear();
        driver.findElement(By.name("job_title")).sendKeys(CUSTOMER_JOB_TITLE);
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(CUSTOMER_MOBILE);
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(CUSTOMER_PHONE);
        driver.findElement(By.name("fax")).clear();
        driver.findElement(By.name("fax")).sendKeys(CUSTOMER_FAX);
        driver.findElement(By.name("website")).clear();
        driver.findElement(By.name("website")).sendKeys(CUSTOMER_WEBSITE);
        new Select(driver.findElement(By.id("rep_id-field"))).selectByVisibleText(CUSTOMER_REP);

        driver.findElement(By.xpath("(//img[@alt='Edit'])[3]")).click();
        driver.findElement(By.xpath("(//img[@alt='Edit'])[2]")).click();
        if (CUSTOMER_BILLING_ADDRESS_REQ == 1) {
            driver.findElement(By.name("shipping_address")).clear();
            driver.findElement(By.name("shipping_address")).sendKeys(CUSTOMER_SHIP_ADDRESS_1);
            driver.findElement(By.name("shipping_address_2")).clear();
            driver.findElement(By.name("shipping_address_2")).sendKeys(CUSTOMER_SHIP_ADDRESS_2);
            driver.findElement(By.name("shipping_city")).clear();
            driver.findElement(By.name("shipping_city")).sendKeys(CUSTOMER_SHIP_CITY);
            driver.findElement(By.name("shipping_state")).clear();
            driver.findElement(By.name("shipping_state")).sendKeys(CUSTOMER_SHIP_REGION);
            driver.findElement(By.name("shipping_postal_code")).clear();
            driver.findElement(By.name("shipping_postal_code")).sendKeys(CUSTOMER_SHIP_POSTAL_CODE);
            driver.findElement(By.name("shipping_country")).clear();
            driver.findElement(By.name("shipping_country")).sendKeys(CUSTOMER_SHIP_COUNTRY);
        } else {
            if (!driver.findElement(By.id("billing_address_same_as_shipping")).isSelected()) {
                driver.findElement(By.cssSelector(".input-label")).click();
            }
        }
        driver.findElement(By.cssSelector(".heading-button")).click();
        Thread.sleep(3000);
        //
        try {
            assertEquals(CUSTOMER_COMPANY_NAME, driver.findElement(By.name("company_name")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_EMAIL, driver.findElement(By.id("customer-email")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_REP, driver.findElement(By.id("customer-rep")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_FIRST_NAME, driver.findElement(By.id("customer-first-name")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_LAST_NAME, driver.findElement(By.id("customer-last-name")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_JOB_TITLE, driver.findElement(By.id("customer-job")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_MOBILE, driver.findElement(By.id("customer-mobile")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_PHONE, driver.findElement(By.id("customer-phone")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_FAX, driver.findElement(By.id("customer-fax")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_WEBSITE, driver.findElement(By.id("customer-site")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        if (CUSTOMER_BILLING_ADDRESS_REQ == 0) {
            try {
                assertEquals(CUSTOMER_BILL_ADDRESS_1, driver.findElement(By.id("customer-billing-address")).getText());
            } catch (Error e) {
                BufferHelper.appendBuffer(e.toString());
            }
            try {
                assertEquals(CUSTOMER_BILL_ADDRESS_2, driver.findElement(By.id("customer-billing-address-2")).getText());
            } catch (Error e) {
                BufferHelper.appendBuffer(e.toString());
            }
            driver.findElement(By.id("customer-billing-city"));
            try {
                assertEquals(CUSTOMER_BILL_CITY, driver.findElement(By.id("customer-billing-city")).getText());
            } catch (Error e) {
                BufferHelper.appendBuffer(e.toString());
            }
            try {
                assertEquals(CUSTOMER_BILL_REGION, driver.findElement(By.id("customer-billing-state")).getText());
            } catch (Error e) {
                BufferHelper.appendBuffer(e.toString());
            }
            try {
                assertEquals(CUSTOMER_BILL_POSTAL_CODE, driver.findElement(By.id("customer-billing-postal-code")).getText());
            } catch (Error e) {
                BufferHelper.appendBuffer(e.toString());
            }
            try {
                assertEquals(CUSTOMER_BILL_COUNTRY, driver.findElement(By.id("customer-billing-country")).getText());
            } catch (Error e) {
                BufferHelper.appendBuffer(e.toString());
            }
        }
        try {
            assertEquals(CUSTOMER_SHIP_ADDRESS_1, driver.findElement(By.id("customer-shipping-address")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_SHIP_ADDRESS_2, driver.findElement(By.id("customer-shipping-address-2")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_SHIP_CITY, driver.findElement(By.id("customer-shipping-city")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_SHIP_REGION, driver.findElement(By.id("customer-shipping-state")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_SHIP_POSTAL_CODE, driver.findElement(By.id("customer-shipping-postal-code")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(CUSTOMER_SHIP_COUNTRY, driver.findElement(By.id("customer-shipping-country")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }

  
    }
