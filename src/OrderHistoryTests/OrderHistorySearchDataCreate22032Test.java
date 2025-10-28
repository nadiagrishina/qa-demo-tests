import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class OrderHistorySearchDataCreate22032Test {
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
    public void test22032OrderHistory() throws Exception {
        String DATE_ORDER = "04/12/2019";
        String DATE_ORDER_ = "04/08/2022";
        String DATE_WRONG = "03/15/2022";
        String DATE_WRONG_ = "03/17/2023";

        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(2) .nav-item__name")).click();
        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.xpath("//span[contains(.,'Advanced search')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.cssSelector(".filter-options > .btn")).click();
        driver.findElement(By.id("created_at_checkbox")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("created_at")).clear();
        driver.findElement(By.name("created_at")).sendKeys(DATE_ORDER, "-", DATE_ORDER_, Keys.ENTER);
        String resultSortedTable = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell');filterField = document.getElementsByName('created_at').value;let l = []; let w = 0;for (let i = 1; i<tabl.length;i = i + 14){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if(a != filterField)return false;}return true;").toString();
        Thread.sleep(5000);
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        driver.findElement(By.cssSelector(".btn-clear")).click();
        driver.findElement(By.name("created_at")).clear();
        driver.findElement(By.name("created_at")).sendKeys(String.valueOf(DATE_WRONG), "-", String.valueOf(DATE_WRONG_), Keys.ENTER);
        try {
            assertEquals("No Data Set", driver.findElement(By.xpath("//div[3]/div[2]/div[2]/div")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

    }


}
