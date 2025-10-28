import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class ProductsSearchCategory24022Test {
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
    public void test24022Products() throws Exception {
        String CATEGORY_1 = "Level 3";
        String WRONG_CATEGORY = "Qwertyu";
        driver.get(Cfg.getSiteLink() + "/logout/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(CATEGORY_1, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String resultSortedTable = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell');filterField = document.getElementsByName('name').value;let l = []; let w = 0;for (let i = 0; i<tabl.length;i = i + 6){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }


        driver.findElement(By.linkText("Clear all")).click();
        driver.findElement(By.id("name")).sendKeys(WRONG_CATEGORY, Keys.ENTER);
        try {
            assertEquals("No Data Set", driver.findElement(By.xpath("//div[3]/div[2]/div[2]/div")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

    }


}
