import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;

public class CategoriesSearchFullName25021Test {
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
    public void test25021Categories() throws Exception {
        String CATEGORY_NAME = "Public category";
        String WRONGNAME = "QWE234+7778/41*9)";
        String WRONG_NAME = "QWE234+7778/41*9)";
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.linkText("Categories")).click();
        assertEquals("Categories", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.name("category_name")).clear();
        driver.findElement(By.name("category_name")).sendKeys(CATEGORY_NAME);
        driver.findElement(By.cssSelector(".field > .btn")).click();
        Object isRightResult = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell'); filterField = document.getElementsByClassName('category_name').value; let l = []; let w = 0; for (let i = 0; i<tabl.length;i = i + 5){l[w] = tabl[i]; w++;} for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField) return false;}return true;").toString();
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.linkText("Clear all")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("category_name")).sendKeys(WRONG_NAME);
        driver.findElement(By.cssSelector(".field > .btn")).click();
        try {
            assertEquals("No Data Set", driver.findElement(By.cssSelector(".tabulator-placeholder-contents")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }

}
