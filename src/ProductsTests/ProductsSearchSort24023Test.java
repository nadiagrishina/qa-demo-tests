import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class ProductsSearchSort24023Test {
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
    public void test24023Products() throws Exception {
        String SORT1 = "500";
        String SORT2 = "100";
        String WRONG_SORT = "-3";
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.name("product_sort")).clear();
        driver.findElement(By.name("product_sort")).sendKeys(SORT1, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String resultSortedTable = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell');filterField = document.getElementsByName('sort').value;let l = []; let w = 0;for (let i = 2; i<tabl.length;i = i + 6){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.name("product_sort")).clear();
        driver.findElement(By.name("product_sort")).sendKeys(SORT2, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        resultSortedTable = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell');filterField = document.getElementsByName('sort').value;let l = []; let w = 0;for (let i = 2; i<tabl.length;i = i + 6){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        driver.findElement(By.linkText("Clear all")).click();
        driver.findElement(By.id("name")).sendKeys(WRONG_SORT, Keys.ENTER);
        try {
            assertEquals("No Data Set", driver.findElement(By.xpath("//div[3]/div[2]/div[2]/div")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

    }


}
