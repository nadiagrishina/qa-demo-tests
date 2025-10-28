import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CouponsAdd23031Test {
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
    public void test23031Coupons() throws Exception {
        String COUPON_NAME = "New Coupon";
        String DISCOUNT = "13";
        String START_DATE = "06/11/2022";
        String END_DATE = "06/11/2026";

        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(3) .nav-item__img")).click();
        assertEquals("Coupons", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.linkText("Add coupon")).click();

        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys(COUPON_NAME);
        driver.findElement(By.id("coupon-discount-val")).click();
        driver.findElement(By.id("coupon-discount-val")).sendKeys(DISCOUNT);
        driver.findElement(By.id("coupon-start-date")).click();
        driver.findElement(By.id("coupon-start-date")).sendKeys(START_DATE);
        driver.findElement(By.id("coupon-end-date")).click();
        driver.findElement(By.id("coupon-end-date")).sendKeys(END_DATE);

        driver.findElement(By.cssSelector(".heading-button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
        try {
            assertEquals(COUPON_NAME, driver.findElement(By.id("name")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(DISCOUNT, driver.findElement(By.id("coupon-discount-val")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(START_DATE, driver.findElement(By.id("coupon-start-date")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(END_DATE, driver.findElement(By.id("coupon-end-date")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
