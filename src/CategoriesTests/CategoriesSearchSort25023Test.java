import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class CategoriesSearchSort25023Test {
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
    public void test25023Categories() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.linkText("Categories")).click();
        assertEquals("Categories", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.name("category_sort")).clear();
        driver.findElement(By.name("category_sort")).sendKeys("1");
        driver.findElement(By.cssSelector(".field > .btn")).click();
        Object isRightResult = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell'); filterField = document.getElementsByClassName('sort').value; let l = []; let w = 0; for (let i = 1; i<tabl.length;i = i + 5){l[w] = tabl[i]; w++;} for(let i =0; i< l.length - 1; i++){let a = l[i].firstChild;if (a != filterField) return false;}return true;").toString();
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.name("category_sort")).clear();
        driver.findElement(By.name("category_sort")).sendKeys("333");
        driver.findElement(By.cssSelector(".field > .btn")).click();
        isRightResult = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell'); filterField = document.getElementsByClassName('sort').value; let l = []; let w = 0; for (let i = 1; i<tabl.length;i = i + 5){l[w] = tabl[i]; w++;} for(let i =0; i< l.length - 1; i++){let a = l[i].firstChild;if (a != filterField) return false;}return true;").toString();
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}

