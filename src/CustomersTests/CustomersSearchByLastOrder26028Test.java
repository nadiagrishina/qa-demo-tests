import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class CustomersSearchByLastOrder26028Test {
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
    public void test26028CustomersSearchByLastOrder() throws Exception {
        String LAST_ORDER = "06/11/2023";
        String LAST_ORDER_ = "07/11/2026";
        String WRONG_DATE = "qwert45/";

        driver.get(Cfg.getSiteLink() + "/logout/");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(5) .nav-item__img")).click();
        assertEquals("Customers", driver.findElement(By.xpath("//div[2]/h1")).getText());

        assertEquals("test - Customers", driver.getTitle());

        driver.findElement(By.id("last_order_date")).clear();
        driver.findElement(By.id("last_order_date")).sendKeys(LAST_ORDER + LAST_ORDER_);
        driver.findElement(By.cssSelector(".field > .btn")).click();
        String resultSortedTable = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell');filterField = document.getElementsByName('last_order').value;let l = []; let w = 0;for (let i = 7; i<tabl.length;i = i + 9){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();

        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        driver.findElement(By.linkText("Clear all")).click();
        driver.findElement(By.id("last_order_date")).clear();
        driver.findElement(By.id("last_order_date")).sendKeys(WRONG_DATE);
        driver.findElement(By.cssSelector(".field > .btn")).click();
        try {
            assertEquals("No Data Set", driver.findElement(By.xpath("//div[2]/div[2]/div")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
