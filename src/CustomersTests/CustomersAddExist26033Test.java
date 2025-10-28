import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Select;


public class CustomersAddExist26033Test {
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
    public void test26033Customers() throws Exception {
        String CUSTOMER_COMPANY_NAME = "testtest1";
        String CUSTOMER_EMAIL = "test@test.com";
        String CUSTOMER_STATUS = "Active";
        String CUSTOMER_TYPE = "Buyer";
        String CUSTOMER_PRICE_TYPE = "VIP";
        String CUSTOMER_TAX_STATUS = "Non Taxable";
        String CUSTOMER_REP = "123";
        String CUSTOMER_TAX_NUMBER = "881-882-88-30";
        String CUSTOMER_FIRST_NAME = "Bob";
        String CUSTOMER_LAST_NAME = "Pavelsky";
        String CUSTOMER_JOB_TITLE = "Director";
        String CUSTOMER_MOBILE = "+7 (913) 888-99-00";
        String CUSTOMER_PHONE = "45-12-12";
        String CUSTOMER_FAX = "810-41-1234567890";
        String CUSTOMER_WEBSITE = "https://testtest.net/";
        int CUSTOMER_BILLING_ADDRESS_REQ = 1;
        String CUSTOMER_BILL_ADDRESS_1 = "Lenina 41";
        String CUSTOMER_BILL_CITY = "Orenburg";
        String CUSTOMER_BILL_REGION = "South Russia";
        String CUSTOMER_BILL_POSTAL_CODE = "462200";
        String CUSTOMER_BILL_COUNTRY = "Russia";
        String CUSTOMER_SHIP_ADDRESS_1 = "Lenina 43";
        String CUSTOMER_SHIP_ADDRESS_2 = "Sorokino 19";
        String CUSTOMER_SHIP_CITY = "Orsk";
        String CUSTOMER_SHIP_REGION = "South Russia";
        String CUSTOMER_SHIP_POSTAL_CODE = "462419";
        String CUSTOMER_SHIP_COUNTRY = "Russia";


        driver.get(Cfg.getSiteLink() + "/logout");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(5) .nav-item__img")).click();
        assertEquals("Customers", driver.findElement(By.xpath("//div[2]/h1")).getText());


        driver.findElement(By.linkText("Add customer")).click();

        driver.findElement(By.name("company_name")).clear();
        driver.findElement(By.name("company_name")).sendKeys(CUSTOMER_COMPANY_NAME);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(CUSTOMER_EMAIL);

        new Select(driver.findElement(By.id("status-field"))).selectByVisibleText(CUSTOMER_STATUS);
        new Select(driver.findElement(By.id("type_field"))).selectByVisibleText(CUSTOMER_TYPE);
        new Select(driver.findElement(By.id("price-type-field"))).selectByVisibleText(CUSTOMER_PRICE_TYPE);
        new Select(driver.findElement(By.name("tax_status"))).selectByVisibleText(CUSTOMER_TAX_STATUS);
        new Select(driver.findElement(By.id("rep_id-field"))).selectByVisibleText(CUSTOMER_REP);

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

        if (CUSTOMER_BILLING_ADDRESS_REQ == 1) {
            driver.findElement(By.id("billing_address_same_as_shipping")).click();
            driver.findElement(By.name("billing_address")).clear();
            driver.findElement(By.name("billing_address")).sendKeys(CUSTOMER_BILL_ADDRESS_1);
            driver.findElement(By.name("billing_city")).clear();
            driver.findElement(By.name("billing_city")).sendKeys(CUSTOMER_BILL_CITY);
            driver.findElement(By.name("billing_state")).clear();
            driver.findElement(By.name("billing_state")).sendKeys(CUSTOMER_BILL_REGION);
            driver.findElement(By.name("billing_postal_code")).clear();
            driver.findElement(By.name("billing_postal_code")).sendKeys(String.valueOf(CUSTOMER_BILL_POSTAL_CODE));
            driver.findElement(By.name("billing_country")).clear();
            driver.findElement(By.name("billing_country")).sendKeys(CUSTOMER_BILL_COUNTRY);
        } else {
            if (!driver.findElement(By.id("billing_address_same_as_shipping")).isSelected()) {
                driver.findElement(By.id("billing_address_same_as_shipping")).click();
            }
            ;
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
        driver.findElement(By.cssSelector(".alert-danger"));

    }


}
