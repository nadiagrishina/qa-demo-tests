import java.time.Duration;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;


public class ReportsTimeTest {
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
    public void test40015ReportsTimeTest() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(6) .nav-item__img")).click();
        driver.findElement(By.linkText("Sales Report")).click();

        driver.findElement(By.cssSelector(".item:nth-child(8)")).click();
        String date_from = "01/01/2022";
        try {
            assertEquals(date_from, driver.findElement(By.xpath("//form[@id='form_filter_date']/div[2]/input")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        String date_to = "12/31/2022";
        try {
            assertEquals(date_to, driver.findElement(By.name("date_to")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        driver.findElement(By.xpath("//div[7]")).click();
        date_from = "01/01/2023";
        date_to = "12/31/2023";
        try {
            assertEquals(date_from, driver.findElement(By.xpath("//form[@id='form_filter_date']/div[2]/input")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(date_to, driver.findElement(By.name("date_to")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(7) .nav-item__img")).click();
        driver.findElement(By.linkText("Sales By Product Report")).click();
        driver.findElement(By.cssSelector(".item:nth-child(8)")).click();
        date_from = "01/01/2022";
        try {
            assertEquals(date_from, driver.findElement(By.xpath("//form[@id='form_filter_date']/div[2]/input")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        date_to = "12/31/2022";
        try {
            assertEquals(date_to, driver.findElement(By.name("date_to")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.xpath("//div[7]")).click();
        date_from = "01/01/2023";
        date_to = "12/31/2023";
        try {
            assertEquals(date_from, driver.findElement(By.xpath("//form[@id='form_filter_date']/div[2]/input")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(date_to, driver.findElement(By.name("date_to")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
    

