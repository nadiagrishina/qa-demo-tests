import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class CouponsSearchByStatus23015Test {
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
    public void test23015CouponsSortByStatusASCDESC() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(3) .nav-item__img")).click();
        assertEquals("Coupons", driver.findElement(By.cssSelector("h1")).getText());

        Select status = new Select(driver.findElement(By.name("status")));
        status.selectByVisibleText("Active");
        WebElement element = driver.findElement(By.xpath("//button[contains(.,'Apply')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        Object isRightResult = js.executeScript("let tabl = document.getElementsByClassName('tabulator-cells');filterField = document.getElementsByClassName('status').value;let l = []; let w = 0;for (let i = 4; i<tabl.length;i = i + 6){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        status = new Select(driver.findElement(By.name("status")));
        status.selectByVisibleText("Inactive");
        element = driver.findElement(By.xpath("//button[contains(.,'Apply')]"));
        actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        isRightResult = js.executeScript("let tabl = document.getElementsByClassName('tabulator-cells');filterField = document.getElementsByClassName('status').value;let l = []; let w = 0;for (let i = 4; i<tabl.length;i = i + 6){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
