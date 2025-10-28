import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class ProductsEditStockAvailable24302Test {
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
    public void test24302Products() throws Exception {
        String PRODUCT_NAME = "Test";
        String STOCK_AVAILABLE = "-100";
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.id("name")).sendKeys(PRODUCT_NAME);
        driver.findElement(By.cssSelector(".btn-md")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.linkText(PRODUCT_NAME)).click();

        driver.findElement(By.cssSelector(".product-option-column:nth-child(3) > .form-control")).clear();
        driver.findElement(By.cssSelector(".product-option-column:nth-child(3) > .form-control")).sendKeys(STOCK_AVAILABLE);

        driver.findElement(By.cssSelector(".heading-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.navigate().refresh();
        try {
            assertEquals(STOCK_AVAILABLE, driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(3) > .form-control")).getAttribute("value").toString());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
