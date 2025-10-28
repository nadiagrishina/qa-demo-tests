import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class B2BCustomerPortalSortByName28031Test {
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
    public void test28031B2BCustomerPortalSortByName() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".person__icon")).click();
        driver.findElement(By.linkText("Profile")).click();
        assertEquals("Profile", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.linkText(Cfg.getPortalLink())).click();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Select cust = new Select(driver.findElement(By.id("currentcustomerselector")));
        cust.selectByVisibleText("testbilling");

        //sort by name
        try {
            WebElement button = driver.findElement(By.xpath("//div[@id='block-bottom-options']/form/select"));
            button.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement button = driver.findElement(By.xpath("//div[@id='block-bottom-options']/form/select"));
            button.click();
        }
        Select sort = new Select(driver.findElement(By.cssSelector(".sorting-block > .form-control")));
        sort.selectByVisibleText("Name");
        String resultSortedTable = js.executeScript("tabl = document.getElementsByClassName('main-product-list');filterField = document.getElementsByClassName('title').value;let l = []; let w = 0;for (let i = 2; i<tabl.length;i = i + 5){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        try {
            assertEquals("true", resultSortedTable);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
