import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.*;


public class RemoveProductThatWasOrdered2455Test {
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
    public void test2455RemoveProductThatWasOrdered() throws Exception {
        String PRODUCT_NAME = "testtest.shop 1234567";
        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".btn > img")).click();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.cssSelector(".tabulator-col:nth-child(4) .tabulator-arrow")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".tabulator-row:nth-child(1) > .tabulator-cell:nth-child(2) > a")).click();
        Thread.sleep(1000);
        js.executeScript("document.querySelector('.heading-button', ':after').click();");
        js.executeScript("document.getElementById('deletebutton').click();");

        driver.findElement(By.cssSelector(".confirm")).click();
        driver.findElement(By.cssSelector(".alert:nth-child(3)")).getText();
    }


}
