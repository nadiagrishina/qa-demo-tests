import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class ProductsAddProduct24101Test {
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
    public void test24101Products() throws Exception {
        String PRODUCT_NAME = "FOOD FOR DOGS";
        String SKU = "123";
        String SUP_CODE = "456";
        String BARCODE = "12345";
        String DEPTH = "45";
        String WIDTH = "50";
        String HEIGHT = "15";
        String WEIGHT = "13";
        String SORT = "100";
        String STOCK_AVIABLE = "5";
        String RETAIL = "30";
        String VIP = "45";
        String WHOLESALE = "50";
        String COST = "25";

        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.linkText("Add product")).click();
        assertEquals("Add product", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.id("name")).sendKeys(PRODUCT_NAME);
        driver.findElement(By.id("SKU")).sendKeys(SKU);
        driver.findElement(By.id("supplier-code")).sendKeys(SUP_CODE);
        driver.findElement(By.id("barcode")).sendKeys(BARCODE);
        driver.findElement(By.id("depth")).sendKeys(DEPTH);
        driver.findElement(By.id("width")).sendKeys(WIDTH);
        driver.findElement(By.id("height")).sendKeys(HEIGHT);
        driver.findElement(By.id("weight")).sendKeys(WEIGHT);
        driver.findElement(By.id("sort")).sendKeys(SORT);
        driver.findElement(By.cssSelector(".product-option-column:nth-child(3) > .form-control")).sendKeys(STOCK_AVIABLE);
        driver.findElement(By.cssSelector(".product-option-column:nth-child(4) > .form-control")).sendKeys(RETAIL);
        driver.findElement(By.cssSelector(".product-option-column:nth-child(5) > .form-control")).sendKeys(VIP);
        driver.findElement(By.cssSelector(".product-option-column:nth-child(6) > .form-control")).sendKeys(WHOLESALE);
        driver.findElement(By.cssSelector(".product-option-column:nth-child(7) > .form-control")).sendKeys(COST);

        driver.findElement(By.cssSelector(".heading-button")).click();
        try {
            assertEquals(PRODUCT_NAME, driver.findElement(By.id("name")).getAttribute("value"));
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
            assertEquals(RETAIL, driver.findElement(By.cssSelector(".product-option-column:nth-child(4) > .form-control")).getAttribute("value"));
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
    }


}
