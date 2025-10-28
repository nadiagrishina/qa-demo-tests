import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class CustomersSearchByAddress26024Test {
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
    public void test26024CustomersSearchByAddress() throws Exception {
        String ADDRESS = "Lenina 1";
        String WRONG_ADDRESS = "Qwerty 5";

        driver.get(Cfg.getSiteLink() + "/logout/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(5) .nav-item__img")).click();
        assertEquals("Customers", driver.findElement(By.xpath("//div[2]/h1")).getText());

        assertEquals("test - Customers", driver.getTitle());

        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys(ADDRESS);
        driver.findElement(By.cssSelector(".field > .btn")).click();

        driver.findElement(By.cssSelector(".tabulator-row-odd > .tabulator-cell:nth-child(1)"));
        driver.findElement(By.linkText("Clear all"));
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys(WRONG_ADDRESS);
        driver.findElement(By.cssSelector(".field > .btn")).click();

        try {
            assertEquals("No Data Set", driver.findElement(By.xpath("//div[3]/div[2]/div[2]/div")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
