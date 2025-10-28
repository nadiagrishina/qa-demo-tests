import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class CommissionsSearchByRep55034Test {
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
    public void test55034() throws Exception {
        String REP_NAME1 = "new";
        String WRONG_NAME = "12/65/09";
        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-item__img > path:nth-child(5)")).click();
        assertEquals("Customers", driver.findElement(By.xpath("//div[2]/h1")).getText());

        driver.findElement(By.linkText("Set commissions for reps")).click();
        assertEquals("Commission for Reps", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.name("rep")).click();
        driver.findElement(By.name("rep")).sendKeys(REP_NAME1);
        driver.findElement(By.cssSelector(".field > .btn")).click();
        Object isRightResult = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell'); filterField = document.getElementsByClassName('rep').value; let l = []; let w = 0; for (let i = 1; i<tabl.length;i = i + 3){l[w] = tabl[i]; w++;} for(let i =0; i< l.length - 1; i++){let a = l[i].firstChild;if (a != filterField) return false;}return true;").toString();
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.linkText("Clear all")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("rep")).sendKeys(WRONG_NAME);
        driver.findElement(By.cssSelector(".field > .btn")).click();
        Thread.sleep(1000);
        try {
            assertEquals("No Data Set", driver.findElement(By.xpath("//div[2]/div[2]/div")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

    }


}
