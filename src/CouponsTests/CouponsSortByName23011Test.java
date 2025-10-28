import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class CouponsSortByName23011Test {
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
    public void test23011CouponsSortByNameASCDESC() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(3) .nav-item__img")).click();
        assertEquals("Coupons", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.cssSelector(".tabulator-col:nth-child(1) .tabulator-arrow")).click();
        String resultSortedTable = js.executeScript("let tabl = document.getElementsByClassName('tabulator-cells'); let columnValues = [];let a = document.getElementsByClassName('tabulator-cell');for(let i = 0; i < a.length; i+= 6){columnValues.push(a[i].title);}for(let i = 0; i <columnValues.length - 1; i++){if(tabl[i] <= tabl[i + 1]){return false;}return true;}").toString();
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.cssSelector(".tabulator-col:nth-child(1) .tabulator-arrow")).click();
        resultSortedTable = js.executeScript("let tabl = document.getElementsByClassName('tabulator-cells'); let columnValues = [];let a = document.getElementsByClassName('tabulator-cell');for(let i = 0; i < a.length; i+= 6){columnValues.push(a[i].title);}for(let i = 0; i <columnValues.length - 1; i++){if(tabl[i] >= tabl[i + 1]){return false;}return true;}").toString();
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
