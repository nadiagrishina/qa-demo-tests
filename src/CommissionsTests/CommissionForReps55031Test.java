import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Select;


public class CommissionForReps55031Test {
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
    public void test55031CommissionForReps() throws Exception {
        String PLAN_NAME = "Premium";
        String PLAN_COMMISSION_PCT_1 = "30";
        String REP_NAME = "123 Test";
        String REP_ORDER = "123";
        String COMPANY_NAME = "Test";
        String CUSTOMER_PRODUCT_1 = "Ordered product";
        String CUSTOMER_PRICE_PRODUCT_1 = "20";
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-item__img > path:nth-child(5)")).click();
        assertEquals("Customers", driver.findElement(By.xpath("//div[2]/h1")).getText());
        driver.findElement(By.linkText("Set commissions for reps")).click();
        assertEquals("Commission for Reps", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.linkText("Add new commission plan")).click();
        assertEquals("Add Commission plan", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.id("customer-plan-name")).clear();
        driver.findElement(By.id("customer-plan-name")).sendKeys(PLAN_NAME);
        driver.findElement(By.id("customer-plan-percent")).clear();
        driver.findElement(By.id("customer-plan-percent")).sendKeys(String.valueOf(PLAN_COMMISSION_PCT_1));
        WebElement radioElement = driver.findElement(By.cssSelector(".custom-input:nth-child(3) > .input-label"));
        radioElement.click();
        Select rep = new Select(driver.findElement(By.name("customer-assigned-reps")));
        rep.selectByVisibleText(REP_NAME);
        driver.findElement(By.cssSelector(".heading-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        try {
            assertEquals(PLAN_NAME, driver.findElement(By.id("customer-plan-name")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(PLAN_COMMISSION_PCT_1, driver.findElement(By.id("customer-plan-percent")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            Object isChecked = driver.findElement(By.id("comission-approve-cond-2")).isSelected();
            Boolean b = true;
            assertEquals(b, isChecked);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(REP_NAME, driver.findElement(By.xpath("//div[2]/div[2]/div/div/div")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
//        //проверка в заказе
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(3) .nav-item__img")).click();
        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.cssSelector(".btn-bright")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        assertEquals("Place new order", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.cssSelector(".show > .bs-searchbox > .form-control")).sendKeys(COMPANY_NAME);
        driver.findElement(By.cssSelector(".bs-searchbox > .form-control")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        Select rep_select = new Select(driver.findElement(By.id("rep_select")));
        rep_select.selectByVisibleText(REP_ORDER);
        driver.findElement(By.cssSelector(".dropup .filter-option-inner-inner")).sendKeys(REP_ORDER);
        driver.findElement(By.cssSelector(".dropup .filter-option-inner-inner")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.findElement(By.cssSelector(".product_item_select .filter-option-inner-inner")).click();
        driver.findElement(By.cssSelector(".show .form-control")).sendKeys(CUSTOMER_PRODUCT_1, Keys.ENTER);
        driver.findElement(By.name("price[]")).clear();
        driver.findElement(By.name("price[]")).sendKeys(String.valueOf(CUSTOMER_PRICE_PRODUCT_1));

        driver.findElement(By.cssSelector(".heading-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }


//
}
