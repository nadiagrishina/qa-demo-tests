import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;


public class SalesByProductReportSortByItemsSold40012Test {
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
    public void test40012SalesByProductReportSortByItemsSold() throws Exception {

                driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(6) .nav-item__img")).click();
        driver.findElement(By.linkText("Sales By Product Report")).click();

        WebElement element = driver.findElement(By.xpath("//div/div/div[2]/div/div/div[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        String resultSortedTable = js.executeScript("tabl = document.getElementsByClassName('tabulator-cells');filterField = document.getElementsByClassName('quantity').value;let l = []; let w = 0;for (let i = 1; i<tabl.length;i = i + 3){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        assertEquals("true", resultSortedTable);
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.xpath("//div/div/div[2]/div/div/div[2]"));
        actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        resultSortedTable = js.executeScript("tabl = document.getElementsByClassName('tabulator-cells');filterField = document.getElementsByClassName('quantity').value;let l = []; let w = 0;for (let i = 1; i<tabl.length;i = i + 3){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        assertEquals("true", resultSortedTable);
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }

  
    }
