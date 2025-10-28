import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Select;


public class OrderHistorySearchPaymentMethod22038Test {
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
    public void test22038OrderHistory() throws Exception {
        String METHOD_1 = "Card";
        String METHOD_2 = "NET15";
        String METHOD_3 = "CHECK";

        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(2) .nav-item__name")).click();
        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.xpath("//span[contains(.,'Advanced search')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.cssSelector(".filter-options > .btn")).click();
        driver.findElement(By.id("payment_method_checkbox")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        this.isValuesCorrectInTable(METHOD_1, true);
        this.isValuesCorrectInTable(METHOD_2, true);
        this.isValuesCorrectInTable(METHOD_3, false);
    }
    protected void isValuesCorrectInTable(String filterValue, boolean expectedValue) throws InterruptedException {
        Select payment_method = new Select(driver.findElement(By.id("payment_method_filter")));
        payment_method.deselectAll();
        payment_method.selectByVisibleText(filterValue);
        Thread.sleep(2000);

        boolean result = true;
        int rowsCount = driver.findElements(By.className("tabulator-row")).size();
        if (rowsCount == 0) {
            result = false;
        }
        for (int i = 1; i < rowsCount + 1; i++) {
            String paymentMethod = driver.findElement(By.xpath("//*[@id=\"dataTable\"]/div[2]/div/div[" + i + "]/div[11]")).getText();
            if (!paymentMethod.contains(filterValue)) {
                result = false;
                break;
            }
        }
        try {
            assertEquals(expectedValue, result);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }
  

}
