import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class OrderHistorySearchPaymentStatus220312Test {
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
    public void test220312OrderHistory() throws Exception {
        String STATUS_1 = "Paid";
        String STATUS_2 = "Not paid";
        String STATUS_3 = "Voided";

        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(2) .nav-item__name")).click();
        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.xpath("//span[contains(.,'Advanced search')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.cssSelector(".filter-options > .btn")).click();
        driver.findElement(By.id("payment_status_checkbox")).click();
        Select payment_method = new Select(driver.findElement(By.id("payment_status_filter")));
        payment_method.selectByVisibleText(STATUS_1);
        Object isRightResult = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell');filterField = document.getElementById('payment_status_filter').value;let l = []; let w = 0;for (let i = 3; i<tabl.length;i = i + 14){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.linkText("Clear all")).click();
        payment_method = new Select(driver.findElement(By.id("payment_status_filter")));
        payment_method.selectByVisibleText(STATUS_2);
        isRightResult = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell');filterField = document.getElementById('payment_status_filter').value;let l = []; let w = 0;for (let i = 3; i<tabl.length;i = i + 14){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        driver.findElement(By.linkText("Clear all")).click();
        payment_method = new Select(driver.findElement(By.id("payment_status_filter")));
        payment_method.selectByVisibleText(STATUS_3);
        isRightResult = js.executeScript("tabl = document.getElementsByClassName('tabulator-cell');filterField = document.getElementById('payment_status_filter').value;let l = []; let w = 0;for (let i = 3; i<tabl.length;i = i + 14){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
