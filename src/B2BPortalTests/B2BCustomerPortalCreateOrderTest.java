import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class B2BCustomerPortalCreateOrderTest {
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
    public void testB2BCustomerPortalCreateOrderTest() throws Exception {
        String ORDER_NOTES = "Order notes 123";
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".person__icon")).click();
        driver.findElement(By.linkText("Profile")).click();
        assertEquals("Profile", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.linkText(Cfg.getPortalLink())).click();

        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Select cust = new Select(driver.findElement(By.id("currentcustomerselector")));
        cust.selectByVisibleText("testbilling");
        Thread.sleep(1000);
        try {
            WebElement input1 = driver.findElement(By.xpath("//input[2]"));
            input1.sendKeys("5", Keys.ENTER);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement input2 = driver.findElement(By.xpath("//input[2]"));
            input2.sendKeys("5", Keys.ENTER);
        }
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".data")).click();

        Thread.sleep(1000);
        cust = new Select(driver.findElement(By.id("currentcustomerselector")));
        cust.selectByVisibleText("testbilling");
        driver.findElement(By.xpath("//button[contains(.,'Ok')]")).click();
        driver.findElement(By.cssSelector("#order-notes")).click();
        driver.findElement(By.cssSelector("#order-notes")).sendKeys(ORDER_NOTES);
        driver.findElement(By.cssSelector(".controls > .btn")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(By.id("submit"));

        driver.get(Cfg.getSiteLink() + "/orders");
        Thread.sleep(2000);
        js.executeScript("document.querySelector('.tabulator-col:nth-child(2) .tabulator-col-sorter').click();");
        Thread.sleep(2000);
        js.executeScript("document.querySelector('.tabulator-col:nth-child(2) .tabulator-col-sorter').click();");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='dataTable']/div[2]/div/div/div/a")).click();
        Thread.sleep(2000);
        assertEquals(ORDER_NOTES, driver.findElement(By.xpath("//textarea[@name='notes']")).getText());

    }
}
