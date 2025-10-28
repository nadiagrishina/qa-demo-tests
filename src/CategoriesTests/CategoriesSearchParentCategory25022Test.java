import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class CategoriesSearchParentCategory25022Test {
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
    public void test25022CategoriesParentCategory() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.linkText("Categories")).click();
        assertEquals("Categories", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.name("parent_category_name")).clear();
        driver.findElement(By.name("parent_category_name")).sendKeys("Level 1");
        driver.findElement(By.cssSelector(".field > .btn")).click();
        Object isRightResult = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell'); filterField = document.getElementsByClassName('parent_category').value; let l = []; let w = 0; for (let i = 2; i<tabl.length;i = i + 5){l[w] = tabl[i]; w++;} for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField) return false;}return true;").toString();
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.name("parent_category_name")).clear();
        driver.findElement(By.name("parent_category_name")).sendKeys("Level 3");
        driver.findElement(By.cssSelector(".field > .btn")).click();
        isRightResult = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell'); filterField = document.getElementsByClassName('parent_category').value; let l = []; let w = 0; for (let i = 2; i<tabl.length;i = i + 5){l[w] = tabl[i]; w++;} for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField) return false;}return true;").toString();
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}


  

