import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class DeleteCustomerWithOrder2606Test {
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
    public void test2606Customers() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(2) .nav-item__name")).click();
        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.cssSelector(".tabulator-row:nth-child(1) > .tabulator-cell:nth-child(1) > a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        String COMPANY_NAME = driver.findElement(By.id("company-name")).getText();
        Thread.sleep(2000);
        try {
            WebElement button = driver.findElement(By.cssSelector(".nav-list-item:nth-child(6) .nav-item__img"));
            button.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement button = driver.findElement(By.cssSelector(".nav-list-item:nth-child(6) .nav-item__img"));
            button.click();
        }
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(5) .nav-item__img")).click();
        assertEquals("Customers", driver.findElement(By.xpath("//div[2]/h1")).getText());

        assertEquals("test - Customers", driver.getTitle());

        driver.findElement(By.xpath("//input[@name='company_name']")).sendKeys(COMPANY_NAME);
        driver.findElement(By.cssSelector(".field > .btn")).click();
        driver.findElement(By.cssSelector(".tabulator-row:nth-child(1) > .tabulator-cell:nth-child(1) > a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

        assertEquals("test - Update customer", driver.getTitle());
        js.executeScript("document.querySelector('.heading-button', ':after').click();");
        js.executeScript("document.getElementById('deletebutton').click();");

        driver.findElement(By.cssSelector(".confirm")).click();
        Thread.sleep(1000);
        assertEquals("You can’t delete customers that have orders. You can only deactivate them", driver.findElement(By.cssSelector(".alert:nth-child(3)")).getText());
    }


}

  

