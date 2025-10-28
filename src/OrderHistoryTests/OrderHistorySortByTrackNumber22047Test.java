import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class OrderHistorySortByTrackNumber22047Test {
    private WebDriver driver;
    private StringBuffer verificationErrors = BufferHelper.getNewBuffer();
    JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        driver = Cfg.getDriver();
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void test22047OrderHistory() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(2) .nav-item__name")).click();
        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());

        js.executeScript("document.querySelector('.tabulator-col:nth-child(10) .tabulator-col-sorter').click();");
        String resultSortedTable = js.executeScript("tabl = document.getElementsByClassName('tabulator-cells');filterField = document.getElementsByClassName('tracking_number').value;let l = []; let w = 0;for (let i = 9; i<tabl.length;i = i + 15){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        assertEquals("true", resultSortedTable);
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        //Next
        js.executeScript("document.querySelector('.tabulator-page:nth-child(4)').click();");
        resultSortedTable = js.executeScript("tabl = document.getElementsByClassName('tabulator-cells');filterField = document.getElementsByClassName('tracking_number').value;let l = []; let w = 0;for (let i = 9; i<tabl.length;i = i + 15){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        assertEquals("true", resultSortedTable);
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        js.executeScript("document.querySelector('.tabulator-col:nth-child(10) .tabulator-col-sorter').click();");
        resultSortedTable = js.executeScript("tabl = document.getElementsByClassName('tabulator-cells');filterField = document.getElementsByClassName('tracking_number').value;let l = []; let w = 0;for (let i = 9; i<tabl.length;i = i + 15){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        assertEquals("true", resultSortedTable);
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
