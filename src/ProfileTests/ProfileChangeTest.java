import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.*;


public class ProfileChangeTest {
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
    public void test20301Profile() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("test");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("testtest");
        driver.findElement(By.cssSelector(".btn")).click();

        driver.findElement(By.cssSelector(".person__icon")).click();
        driver.findElement(By.linkText("Profile")).click();
        assertEquals("Profile", driver.findElement(By.cssSelector("h1")).getText());

        String companyName = driver.findElement(By.id("company-field")).getAttribute("value");
        if (Objects.equals(companyName, "dev")) {
            driver.findElement(By.id("company-field")).clear();
            driver.findElement(By.id("company-field")).sendKeys("dev");
        } else {
            driver.findElement(By.id("company-field")).clear();
            driver.findElement(By.id("company-field")).sendKeys("testtest");
        }
        companyName = driver.findElement(By.id("company-field")).getAttribute("value");

        String emailAddress = driver.findElement(By.id("email-field")).getAttribute("value");
        if (Objects.equals(emailAddress, "alexey1.testtest@yandex.ru")) {
            driver.findElement(By.id("email-field")).clear();
            driver.findElement(By.id("email-field")).sendKeys("alexey1.testtest@yandex.ru");
        } else {
            driver.findElement(By.id("email-field")).clear();
            driver.findElement(By.id("email-field")).sendKeys("test");
        }

        emailAddress = driver.findElement(By.id("email-field")).getAttribute("value");
        String faxAddress = driver.findElement(By.id("fax-field")).getAttribute("value");
        if (Objects.equals(faxAddress, "1234567890")) {
            driver.findElement(By.id("fax-field")).clear();
            driver.findElement(By.id("fax-field")).sendKeys("0987654321");
        } else {
            driver.findElement(By.id("fax-field")).clear();
            driver.findElement(By.id("fax-field")).sendKeys("1234567890");
        }
        faxAddress = driver.findElement(By.id("fax-field")).getAttribute("value");
        String phoneNumber = driver.findElement(By.id("phone-field")).getAttribute("value");
        if (Objects.equals(phoneNumber, "+7(999) 999 99-99")) {
            driver.findElement(By.id("phone-field")).clear();
            driver.findElement(By.id("phone-field")).sendKeys("+7(999) 999 99-90");
        } else {
            driver.findElement(By.id("phone-field")).clear();
            driver.findElement(By.id("phone-field")).sendKeys("+7(999) 999 99-90");
        }
        phoneNumber = driver.findElement(By.id("phone-field")).getAttribute("value");
        String taxIdNumber = driver.findElement(By.id("tax-field")).getAttribute("value");
        if (Objects.equals(taxIdNumber, "123-45-6789")) {
            driver.findElement(By.id("tax-field")).clear();
            driver.findElement(By.id("tax-field")).sendKeys("987-65-4321");
        } else {
            driver.findElement(By.id("tax-field")).clear();
            driver.findElement(By.id("tax-field")).sendKeys("987-65-4321");
        }
        taxIdNumber = driver.findElement(By.id("tax-field")).getAttribute("value");
        String billingAddress1 = driver.findElement(By.id("address-field")).getAttribute("value");
        if (Objects.equals(billingAddress1, "Kosareva 63")) {
            driver.findElement(By.id("address-field")).clear();
            driver.findElement(By.id("address-field")).sendKeys("Lenina 21");
        } else {
            driver.findElement(By.id("address-field")).clear();
            driver.findElement(By.id("address-field")).sendKeys("Kosareva 63");
        }
        billingAddress1 = driver.findElement(By.id("address-field")).getAttribute("value");
        String billingAddress2 = driver.findElement(By.name("billing_address_2")).getAttribute("value");
        if (Objects.equals(billingAddress2, "Molodogvardeycev 33")) {
            driver.findElement(By.name("billing_address_2")).clear();
            driver.findElement(By.name("billing_address_2")).sendKeys("Shevchenko 4");
        } else {
            driver.findElement(By.name("billing_address_2")).clear();
            driver.findElement(By.name("billing_address_2")).sendKeys("Molodogvardeycev 33");
        }
        billingAddress2 = driver.findElement(By.name("billing_address_2")).getAttribute("value");
        String billingCityName = driver.findElement(By.id("city-field")).getAttribute("value");
        if (Objects.equals(billingCityName, "Moscow")) {
            driver.findElement(By.id("city-field")).clear();
            driver.findElement(By.id("city-field")).sendKeys("Krasnodar");
        } else {
            driver.findElement(By.id("city-field")).clear();
            driver.findElement(By.id("city-field")).sendKeys("Moscow");
        }
        billingCityName = driver.findElement(By.id("city-field")).getAttribute("value");
        String billingRegionName = driver.findElement(By.id("state-field")).getAttribute("value");
        if (Objects.equals(billingRegionName, "Moscow Region")) {
            driver.findElement(By.id("state-field")).clear();
            driver.findElement(By.id("state-field")).sendKeys("Krasnodar Region");
        } else {
            driver.findElement(By.id("state-field")).clear();
            driver.findElement(By.id("state-field")).sendKeys("Moscow Region");
        }
        billingRegionName = driver.findElement(By.id("state-field")).getAttribute("value");
        String billingPostalCode = driver.findElement(By.id("postal-code-field")).getAttribute("value");
        if (Objects.equals(billingPostalCode, "101000")) {
            driver.findElement(By.id("postal-code-field")).clear();
            driver.findElement(By.id("postal-code-field")).sendKeys("350000");
        } else {
            driver.findElement(By.id("postal-code-field")).clear();
            driver.findElement(By.id("postal-code-field")).sendKeys("101000");
        }
        billingPostalCode = driver.findElement(By.id("postal-code-field")).getAttribute("value");
        String billingCountryName = driver.findElement(By.id("country-field")).getAttribute("value");
        if (Objects.equals(billingCountryName, "Central Russia")) {
            driver.findElement(By.id("country-field")).clear();
            driver.findElement(By.id("country-field")).sendKeys("South Russia");
        } else {
            driver.findElement(By.id("country-field")).clear();
            driver.findElement(By.id("country-field")).sendKeys("Central Russia");
        }
        billingCountryName = driver.findElement(By.id("country-field")).getAttribute("value");
        WebElement bill = driver.findElement(By.id("billing-address-switch"));
        boolean selectState = bill.isSelected();

        if (selectState) {
            bill.click();
        }
        String shippingAddress1 = driver.findElement(By.id("shipping-address-1-field")).getAttribute("value");
        if (Objects.equals(shippingAddress1, "Kosareva 66")) {
            driver.findElement(By.id("shipping-address-1-field")).clear();
            driver.findElement(By.id("shipping-address-1-field")).sendKeys("Lenina 25");
        } else {
            driver.findElement(By.id("shipping-address-1-field")).clear();
            driver.findElement(By.id("shipping-address-1-field")).sendKeys("Kosareva 66");
        }
        shippingAddress1 = driver.findElement(By.id("shipping-address-1-field")).getAttribute("value");
        String shippingAddress2 = driver.findElement(By.name("shipping_address_2")).getAttribute("value");
        if (Objects.equals(shippingAddress2, "Molodogvardeycev 37")) {
            driver.findElement(By.name("shipping_address_2")).clear();
            driver.findElement(By.name("shipping_address_2")).sendKeys("Shevchenko 1");
        } else {
            driver.findElement(By.name("shipping_address_2")).clear();
            driver.findElement(By.name("shipping_address_2")).sendKeys("Molodogvardeycev 37");
        }
        shippingAddress2 = driver.findElement(By.name("shipping_address_2")).getAttribute("value");
        String shippingCityName = driver.findElement(By.id("shipping-city-field")).getAttribute("value");
        if (Objects.equals(shippingCityName, "Dubna")) {
            driver.findElement(By.id("shipping-city-field")).clear();
            driver.findElement(By.id("shipping-city-field")).sendKeys("Sochi");
        } else {
            driver.findElement(By.id("shipping-city-field")).clear();
            driver.findElement(By.id("shipping-city-field")).sendKeys("Dubna");
        }
        shippingCityName = driver.findElement(By.id("shipping-city-field")).getAttribute("value");
        String shippingRegionName = driver.findElement(By.id("shipping-state-field")).getAttribute("value");
        if (Objects.equals(shippingRegionName, "Moscow Region 1")) {
            driver.findElement(By.id("shipping-state-field")).clear();
            driver.findElement(By.id("shipping-state-field")).sendKeys("Krasnodar Region 1");
        } else {
            driver.findElement(By.id("shipping-state-field")).clear();
            driver.findElement(By.id("shipping-state-field")).sendKeys("Moscow Region 1");
        }
        shippingRegionName = driver.findElement(By.id("shipping-state-field")).getAttribute("value");
        String shippingPostalCode = driver.findElement(By.id("shipping-postal-code-field")).getAttribute("value");
        if (Objects.equals(shippingPostalCode, "101001")) {
            driver.findElement(By.id("shipping-postal-code-field")).clear();
            driver.findElement(By.id("shipping-postal-code-field")).sendKeys("350001");
        } else {
            driver.findElement(By.id("shipping-postal-code-field")).clear();
            driver.findElement(By.id("shipping-postal-code-field")).sendKeys("101001");
        }
        shippingPostalCode = driver.findElement(By.id("shipping-postal-code-field")).getAttribute("value");
        String shippingCountryName = driver.findElement(By.id("shipping-country-field")).getAttribute("value");
        if (Objects.equals(shippingCountryName, "Central Russia 1")) {
            driver.findElement(By.id("shipping-country-field")).clear();
            driver.findElement(By.id("shipping-country-field")).sendKeys("South Russia 1");
        } else {
            driver.findElement(By.id("shipping-country-field")).clear();
            driver.findElement(By.id("shipping-country-field")).sendKeys("Central Russia 1");
        }
        shippingCountryName = driver.findElement(By.id("shipping-country-field")).getAttribute("value");
        driver.findElement(By.cssSelector(".dropdown > .btn-primary")).click();
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(emailAddress);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("testtest");
        driver.findElement(By.cssSelector(".btn")).click();
        driver.get(Cfg.getSiteLink() + "/profile");
        String companyNameNow = driver.findElement(By.id("company-field")).getAttribute("value");
        try {
            assertEquals(companyName, companyNameNow);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        String emailAddressNow = driver.findElement(By.id("email-field")).getAttribute("value");
        try {
            assertEquals(emailAddress, emailAddressNow);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        String faxAddressNow = driver.findElement(By.id("fax-field")).getAttribute("value");
        try {
            assertEquals(faxAddress, faxAddressNow);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        String phoneNumberNow = driver.findElement(By.id("phone-field")).getAttribute("value");
        try {
            assertEquals(phoneNumber, phoneNumberNow);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        String taxIdNumberNow = driver.findElement(By.id("tax-field")).getAttribute("value");
        try {
            assertEquals(taxIdNumber, taxIdNumberNow);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        String billingAddress1Now = driver.findElement(By.id("address-field")).getAttribute("value");
        try {
            assertEquals(billingAddress1, billingAddress1Now);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        String billingAddress2Now = driver.findElement(By.name("billing_address_2")).getAttribute("value");
        try {
            assertEquals(billingAddress2, billingAddress2Now);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        String billingCityNameNow = driver.findElement(By.id("city-field")).getAttribute("value");
        try {
            assertEquals(billingCityName, billingCityNameNow);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        String billingRegionNameNow = driver.findElement(By.id("state-field")).getAttribute("value");
        try {
            assertEquals(billingRegionName, billingRegionNameNow);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        String billingPostalCodeNow = driver.findElement(By.id("postal-code-field")).getAttribute("value");
        try {
            assertEquals(billingPostalCode, billingPostalCodeNow);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        String billingCountryNameNow = driver.findElement(By.id("country-field")).getAttribute("value");
        try {
            assertEquals(billingCountryName, billingCountryNameNow);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        String shippingAddress1Now = driver.findElement(By.id("shipping-address-1-field")).getAttribute("value");
        try {
            assertEquals(shippingAddress1, shippingAddress1Now);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        String shippingAddress2Now = driver.findElement(By.id("shipping-address-2-field")).getAttribute("value");
        try {
            assertEquals(shippingAddress2, shippingAddress2Now);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        String shippingCityNameNow = driver.findElement(By.id("shipping-city-field")).getAttribute("value");
        try {
            assertEquals(shippingCityName, shippingCityNameNow);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        String shippingRegionNameNow = driver.findElement(By.id("shipping-state-field")).getAttribute("value");
        try {
            assertEquals(shippingRegionName, shippingRegionNameNow);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        String shippingPostalCodeNow = driver.findElement(By.id("shipping-postal-code-field")).getAttribute("value");
        try {
            assertEquals(shippingPostalCode, shippingPostalCodeNow);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        String shippingCountryNameNow = driver.findElement(By.id("shipping-country-field")).getAttribute("value");
        try {
            assertEquals(shippingCountryName, shippingCountryNameNow);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        driver.findElement(By.id("email-field")).clear();
        driver.findElement(By.id("email-field")).sendKeys("test");
        driver.findElement(By.cssSelector(".dropdown > .btn-primary")).click();

        emailAddressNow = driver.findElement(By.id("email-field")).getAttribute("value");
        try {
            assertEquals(emailAddressNow, driver.findElement(By.id("email-field")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

    }


}
