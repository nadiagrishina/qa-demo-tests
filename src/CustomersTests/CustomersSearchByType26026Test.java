import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Select;


public class CustomersSearchByType26026Test {
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
    public void test26026CustomersSearchByType() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(5) .nav-item__img")).click();
        assertEquals("Customers", driver.findElement(By.xpath("//div[2]/h1")).getText());
        Select type = new Select(driver.findElement(By.name("type")));
        type.selectByVisibleText("Buyer");
        driver.findElement(By.cssSelector(".field > .btn")).click();
        String resultSortedTable = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell');filterField = document.getElementsByName('type').value;let l = []; let w = 0;for (let i = 4; i<tabl.length;i = i + 8){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.linkText("Clear all")).click();
        type = new Select(driver.findElement(By.name("type")));
        type.selectByVisibleText("Rep");
        driver.findElement(By.cssSelector(".field > .btn")).click();
        resultSortedTable = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell');filterField = document.getElementsByName('type').value;let l = []; let w = 0;for (let i = 4; i<tabl.length;i = i + 8){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
