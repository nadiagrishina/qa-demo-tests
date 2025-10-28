import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class ProductsEditProduct24301Test {
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
    public void test24301Products() throws Exception {
        String PRODUCT_NAME = "FOOD FOR DOGS";
        String NEW_PRODUCT_NAME = "DOGS";
        String DEPTH = "16";
        String BARCODE = "15";
        String SUP_CODE = "46";
        String SKU = "13";
        String WIDTH = "20";
        String HEIGHT = "40";
        String WEIGHT = "70";
        String SORT = "155";
        String STOCK_AVIABLE = "155";
        String RETAIL_1 = "120";
        String VIP = "110";
        String WHOLESALE = "90";
        String COST = "110";
        String OPTION_1 = "option 1";
        String OPTION_2 = "option 2";
        String RETAIL_2 = "220";

        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.id("name")).sendKeys(PRODUCT_NAME, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.linkText(PRODUCT_NAME)).click();

        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(NEW_PRODUCT_NAME);
        driver.findElement(By.id("SKU")).clear();
        driver.findElement(By.id("SKU")).sendKeys(SKU);
        driver.findElement(By.id("supplier-code")).clear();
        driver.findElement(By.id("supplier-code")).sendKeys(SUP_CODE);
        driver.findElement(By.id("barcode")).clear();
        driver.findElement(By.id("barcode")).sendKeys(BARCODE);
        driver.findElement(By.id("depth")).clear();
        driver.findElement(By.id("depth")).sendKeys(DEPTH);
        driver.findElement(By.id("width")).clear();
        driver.findElement(By.id("width")).sendKeys(WIDTH);
        driver.findElement(By.id("height")).clear();
        driver.findElement(By.id("height")).sendKeys(HEIGHT);
        driver.findElement(By.id("weight")).clear();
        driver.findElement(By.id("weight")).sendKeys(WEIGHT);
        driver.findElement(By.id("sort")).sendKeys(WEIGHT);
        driver.findElement(By.id("sort")).clear();
        driver.findElement(By.id("sort")).sendKeys(SORT);

        driver.findElement(By.id("add-option")).click();
        driver.findElement(By.cssSelector("td > .form-control:nth-child(2)")).sendKeys(OPTION_1);
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(2) > .form-control")).clear();
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(2) > .form-control")).sendKeys(SORT);
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(3) > .form-control")).clear();
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(3) > .form-control")).sendKeys(STOCK_AVIABLE);
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(4) > .form-control")).clear();
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(4) > .form-control")).sendKeys(RETAIL_1);
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(5) > .form-control")).clear();
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(5) > .form-control")).sendKeys(VIP);
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(6) > .form-control")).clear();
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(6) > .form-control")).sendKeys(WHOLESALE);
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(7) > .form-control")).clear();
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(7) > .form-control")).sendKeys(COST);
        driver.findElement(By.cssSelector(".product-option-column:nth-child(1) > .form-control")).sendKeys(OPTION_2);
        driver.findElement(By.cssSelector("tr:nth-child(2) > .product-option-column:nth-child(4) > .form-control")).sendKeys(RETAIL_2);
        driver.findElement(By.cssSelector(".heading-button")).click();
        try {
            assertEquals(NEW_PRODUCT_NAME, driver.findElement(By.id("name")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(SKU, driver.findElement(By.id("SKU")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(SUP_CODE, driver.findElement(By.id("supplier-code")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(BARCODE, driver.findElement(By.id("barcode")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(DEPTH, driver.findElement(By.id("depth")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(WIDTH, driver.findElement(By.id("width")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(HEIGHT, driver.findElement(By.id("height")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(WEIGHT, driver.findElement(By.id("weight")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(SORT, driver.findElement(By.id("sort")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(STOCK_AVIABLE, driver.findElement(By.cssSelector(".product-option-column:nth-child(3) > .form-control")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(RETAIL_1, driver.findElement(By.cssSelector(".product-option-column:nth-child(4) > .form-control")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(VIP, driver.findElement(By.cssSelector(".product-option-column:nth-child(5) > .form-control")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(WHOLESALE, driver.findElement(By.cssSelector(".product-option-column:nth-child(6) > .form-control")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(COST, driver.findElement(By.cssSelector(".product-option-column:nth-child(7) > .form-control")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(RETAIL_2, driver.findElement(By.cssSelector("tr:nth-child(2) > .product-option-column:nth-child(4) > .form-control")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(OPTION_2, driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1) > .form-control")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
