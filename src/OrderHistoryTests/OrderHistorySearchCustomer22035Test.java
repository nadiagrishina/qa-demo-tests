import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class OrderHistorySearchCustomer22035Test {
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
    public void test22035OrderHistory() throws Exception {
        final String PART_CUSTOMER_NAME = "wh";
        final String WRONG_CUSTOMER_NAME = "best1";
        final String FULL_CUSTOMER_NAME = "testtest";
        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(2) .nav-item__name")).click();
        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.xpath("//span[contains(.,'Advanced search')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.cssSelector(".filter-options > .btn")).click();
        driver.findElement(By.id("customer_checkbox")).click();
        driver.findElement(By.cssSelector(".filter-options > .btn")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));


        this.isValuesCorrectInTable(PART_CUSTOMER_NAME, true);
        this.isValuesCorrectInTable(WRONG_CUSTOMER_NAME, false);
        this.isValuesCorrectInTable(FULL_CUSTOMER_NAME, true);
    }

    protected void isValuesCorrectInTable(String filterValue, boolean expectedValue) throws InterruptedException {
        driver.findElement(By.id("customer_filter")).clear();
        driver.findElement(By.id("customer_filter")).sendKeys(filterValue, Keys.ENTER);
        Thread.sleep(2000);

        boolean result = true;
        int rowsCount = driver.findElements(By.className("tabulator-row")).size();
        if (rowsCount == 0) {
            result = false;
        }
        for (int i = 1; i < rowsCount + 1; i++) {
            String customerName = driver.findElement(By.xpath("//*[@id=\"dataTable\"]/div[2]/div/div[" + i + "]/div[12]/span/a")).getText();
            if (!customerName.contains(filterValue)) {
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
