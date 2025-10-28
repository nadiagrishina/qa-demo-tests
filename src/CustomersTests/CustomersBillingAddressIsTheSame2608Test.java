import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.*;


public class CustomersBillingAddressIsTheSame2608Test {
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
    public void test2608CustomersBillingAddressIsTheSame() throws Exception {
        String CUSTOMER_COMPANY_NAME = "Billing 2";
        String CUSTOMER_EMAIL = Cfg.getSaltString();
        String CUSTOMER_TAX_NUMBER = "881-882-88-30";
        String CUSTOMER_FIRST_NAME = "Test";
        String CUSTOMER_LAST_NAME = "Test";
        String CUSTOMER_JOB_TITLE = "Director";
        String CUSTOMER_MOBILE = "+7 (913) 888-99-00";
        String CUSTOMER_PHONE = "45-12-12";
        String CUSTOMER_FAX = "810-41-1234567890";
        String CUSTOMER_WEBSITE = "https://testtest.net/";
        String CUSTOMER_BILL_ADDRESS_1 = "Lenina 50";
        String CUSTOMER_BILL_ADDRESS_2 = "Sorokino 50";
        String CUSTOMER_BILL_CITY = "Moscow";
        String CUSTOMER_BILL_REGION = "Central Russia";
        String CUSTOMER_BILL_POSTAL_CODE = "222222";
        String CUSTOMER_BILL_COUNTRY = "Russia";
        String CUSTOMER_SHIP_ADDRESS_1 = "Lenina 50";
        String CUSTOMER_SHIP_ADDRESS_2 = "Sorokino 50";
        String CUSTOMER_SHIP_CITY = "Moscow";
        String CUSTOMER_SHIP_REGION = "Central Russia";
        String CUSTOMER_SHIP_POSTAL_CODE = "222222";
        String CUSTOMER_SHIP_COUNTRY = "Russia";


        driver.get(Cfg.getSiteLink() + "/logout/");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(5) .nav-item__img")).click();
        assertEquals("Customers", driver.findElement(By.xpath("//div[2]/h1")).getText());

        driver.findElement(By.linkText("Add customer")).click();
        driver.findElement(By.name("company_name")).clear();
        driver.findElement(By.name("company_name")).sendKeys(CUSTOMER_COMPANY_NAME);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(CUSTOMER_EMAIL);
        driver.findElement(By.name("tax_number")).clear();
        driver.findElement(By.name("tax_number")).sendKeys(String.valueOf(CUSTOMER_TAX_NUMBER));
        driver.findElement(By.name("first_name")).clear();
        driver.findElement(By.name("first_name")).sendKeys(CUSTOMER_FIRST_NAME);
        driver.findElement(By.name("last_name")).clear();
        driver.findElement(By.name("last_name")).sendKeys(CUSTOMER_LAST_NAME);
        driver.findElement(By.name("job_title")).clear();
        driver.findElement(By.name("job_title")).sendKeys(CUSTOMER_JOB_TITLE);
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(String.valueOf(CUSTOMER_MOBILE));
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(String.valueOf(CUSTOMER_PHONE));
        driver.findElement(By.name("fax")).clear();
        driver.findElement(By.name("fax")).sendKeys(String.valueOf(CUSTOMER_FAX));
        driver.findElement(By.name("website")).clear();
        driver.findElement(By.name("website")).sendKeys(CUSTOMER_WEBSITE);

        if (!driver.findElement(By.id("billing_address_same_as_shipping")).isSelected()) {
            driver.findElement(By.id("billing_address_same_as_shipping")).click();
        }

        driver.findElement(By.name("shipping_address")).clear();
        driver.findElement(By.name("shipping_address")).sendKeys(CUSTOMER_SHIP_ADDRESS_1);
        driver.findElement(By.name("shipping_address_2")).clear();
        driver.findElement(By.name("shipping_address_2")).sendKeys(CUSTOMER_SHIP_ADDRESS_2);
        driver.findElement(By.name("shipping_city")).clear();
        driver.findElement(By.name("shipping_city")).sendKeys(CUSTOMER_SHIP_CITY);
        driver.findElement(By.name("shipping_state")).clear();
        driver.findElement(By.name("shipping_state")).sendKeys(CUSTOMER_SHIP_REGION);
        driver.findElement(By.name("shipping_postal_code")).clear();
        driver.findElement(By.name("shipping_postal_code")).sendKeys(String.valueOf(CUSTOMER_SHIP_POSTAL_CODE));
        driver.findElement(By.name("shipping_country")).clear();
        driver.findElement(By.name("shipping_country")).sendKeys(CUSTOMER_SHIP_COUNTRY);

        driver.findElement(By.cssSelector(".heading-button")).click();

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        try {
            assertEquals(CUSTOMER_FIRST_NAME, driver.findElement(By.id("customer-first-name")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
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
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(2) .nav-item__img")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        assertEquals("Place new order", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.cssSelector(".show > .bs-searchbox > .form-control")).sendKeys(CUSTOMER_COMPANY_NAME);
        driver.findElement(By.cssSelector(".bs-searchbox > .form-control")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
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
        driver.findElement(By.id("customer-shipping-city"));
        try {
            assertEquals(CUSTOMER_SHIP_CITY, driver.findElement(By.id("customer-shipping-city")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.id("customer-shipping-state"));
        try {
            assertEquals(CUSTOMER_SHIP_REGION, driver.findElement(By.id("customer-shipping-state")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.id("customer-shipping-postal-code"));
        try {
            assertEquals(CUSTOMER_SHIP_POSTAL_CODE, driver.findElement(By.id("customer-shipping-postal-code")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.id("customer-shipping-country"));
        try {
            assertEquals(CUSTOMER_SHIP_COUNTRY, driver.findElement(By.id("customer-shipping-country")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.id("customer-billing-address"));
        try {
            assertEquals(CUSTOMER_BILL_ADDRESS_1, driver.findElement(By.id("customer-billing-address")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.id("customer-billing-address-2"));
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
        driver.findElement(By.id("customer-billing-state"));
        try {
            assertEquals(CUSTOMER_BILL_REGION, driver.findElement(By.id("customer-billing-state")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.id("customer-billing-postal-code"));
        try {
            assertEquals(CUSTOMER_BILL_POSTAL_CODE, driver.findElement(By.id("customer-billing-postal-code")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.id("customer-billing-country"));
        try {
            assertEquals(CUSTOMER_BILL_COUNTRY, driver.findElement(By.id("customer-billing-country")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
