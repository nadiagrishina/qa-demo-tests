import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class QuickFiltersTest {
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
    public void testQuickFilters() {
        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(2) .nav-item__name")).click();
        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());

        //Past ETD
        driver.findElement(By.xpath("//label[contains(.,'Past ETD')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//span[contains(.,'Advanced search')]")).click();

        Select shippingStatus = new Select(driver.findElement(By.id("shipping_status_filter")));
        List<WebElement> op = shippingStatus.getOptions();
        String options1[];
        int size = op.size();
        for (int i = 0; i < size; i++) {
            String options = op.get(i).getText();
            options1 += options;
        }


        assertEquals("Not shipped, Awaiting shipment, On hold", shippingStatus.getAllSelectedOptions().getText());
        assertEquals("04/20/2022 - 04/20/2023", driver.findElement(By.id("ship_on_filter")).getText());

    }
}
