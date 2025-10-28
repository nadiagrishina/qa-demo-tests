import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class OrderHistorySearchETD22037Test {
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
    public void test22037OrderHistory() throws Exception {
        String PART_ETD_ORDER = "12/11/2022 - 12/13/2022";
        String WRONG_ETD_ORDER = "01/01/2010";
        String FULL_ETD_ORDER = "06/08/2022";

        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(2) .nav-item__name")).click();
        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.xpath("//span[contains(.,'Advanced search')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.cssSelector(".filter-options > .btn")).click();
        driver.findElement(By.id("ship_on_checkbox")).click();

        driver.findElement(By.name("ship_on")).clear();
        driver.findElement(By.name("ship_on")).sendKeys(PART_ETD_ORDER, Keys.ENTER);
        Thread.sleep(5000);
        Object isRightResult = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell'); filterField = document.getElementById('ship_on_filter').value; let l = []; let w = 0; for (let i = 5; i<tabl.length;i = i + 14){l[w] = tabl[i]; w++;} for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField) return false;}return true;").toString();
        Thread.sleep(5000);
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        driver.findElement(By.name("ship_on")).clear();
        driver.findElement(By.name("ship_on")).sendKeys(WRONG_ETD_ORDER);
        try {
            assertEquals("No Data Set", driver.findElement(By.className("tabulator-placeholder-contents")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        driver.findElement(By.name("ship_on")).clear();
        driver.findElement(By.name("ship_on")).sendKeys(FULL_ETD_ORDER);
        isRightResult = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell'); filterField = document.getElementById('ship_on_filter').value; let l = []; let w = 0; for (let i = 5; i<tabl.length;i = i + 15){l[w] = tabl[i]; w++;} for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField) return false;}return true;").toString();
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }

}
