import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ProductsSortSortBySort24012Test {
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
    public void test24012ProductsSortASCDESC() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        WebElement element = driver.findElement(By.xpath("//div[4]/div/div/div[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        String resultSortedTable = js.executeScript("let tabl = document.getElementsByClassName('tabulator-cells'); let columnValues = [];let a = document.getElementsByClassName('tabulator-cell');for(let i = 2; i < a.length; i+= 7){columnValues.push(a[i].title);}for(let i = 0; i <columnValues.length - 1; i++){if(tabl[i] <= tabl[i + 1]){return false;}return true;}").toString();
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        element = driver.findElement(By.xpath("//div[4]/div/div/div[2]"));
        actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        resultSortedTable = js.executeScript("let tabl = document.getElementsByClassName('tabulator-cells'); let columnValues = [];let a = document.getElementsByClassName('tabulator-cell');for(let i = 2; i < a.length; i+= 7){columnValues.push(a[i].title);}for(let i = 0; i <columnValues.length - 1; i++){if(tabl[i] <= tabl[i + 1]){return false;}return true;}").toString();
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
