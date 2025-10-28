import org.junit.*;


import org.openqa.selenium.*;

import java.time.Duration;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;


public class OrderHistorySearchCustomerPO22039Test {
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
    public void test22039OrderHistory() throws Exception {
        final String PART_PO = "12";
        final String WRONG_PO = "best1";
        final String FULL_PO = "123456";

        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(2) .nav-item__name")).click();
        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.xpath("//span[contains(.,'Advanced search')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.cssSelector(".filter-options > .btn")).click();
        driver.findElement(By.id("customer_po_checkbox")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        this.isValuesCorrectInTable(PART_PO, true);
        this.isValuesCorrectInTable(WRONG_PO, false);
        this.isValuesCorrectInTable(FULL_PO, true);
    }

    protected void isValuesCorrectInTable(String filterValue, boolean expectedValue) throws InterruptedException {
        driver.findElement(By.name("customer_po")).clear();
        driver.findElement(By.name("customer_po")).sendKeys(filterValue, Keys.ENTER);
        Thread.sleep(2000);

        boolean result = true;
        int rowsCount = driver.findElements(By.className("tabulator-row")).size();
        if (rowsCount == 0) {
            result = false;
        }
        for (int i = 1; i < rowsCount + 1; i++) {
            String customerPO = driver.findElement(By.xpath("//*[@id=\"dataTable\"]/div[2]/div/div[" + i + "]/div[13]")).getText();
            if (!customerPO.contains(filterValue)) {
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
