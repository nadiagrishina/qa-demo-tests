import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class DeleteCustomerWaitingForApprovalTest {
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
    public void testDeleteCustomerWaitingForApproval() throws Exception {
        String NAME_CUSTOMER = "Waiting";
        String EMAIL_CUSTOMER = Cfg.getSaltString();
        String COMPANY_CUSTOMER = "Company";
        String PHONE_CUSTOMER = "1234456778919";

        driver.get(Cfg.getPortalLink() + "logout");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.linkText("Request access")).click();

        driver.findElement(By.id("email")).sendKeys(EMAIL_CUSTOMER, Keys.ENTER);
        driver.findElement(By.name("name")).sendKeys(NAME_CUSTOMER);
        driver.findElement(By.name("phone")).sendKeys(PHONE_CUSTOMER);
        driver.findElement(By.name("company")).sendKeys(COMPANY_CUSTOMER);


        driver.findElement(By.cssSelector(".btn-primary")).click();
        Thread.sleep(1000);
        assertEquals("We got your request. Please wait for the approval", driver.findElement(By.cssSelector(".alert-success")).getText());


        driver.get(Cfg.getSiteLink() + "/logout/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(5) .nav-item__img")).click();
        assertEquals("Customers", driver.findElement(By.xpath("//div[2]/h1")).getText());

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL_CUSTOMER);
        driver.findElement(By.cssSelector(".field > .btn")).click();

        driver.findElement(By.cssSelector(".tabulator-row:nth-child(1) > .tabulator-cell:nth-child(1) > a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        assertEquals(COMPANY_CUSTOMER, driver.findElement(By.xpath("//input[@name='company_name']")).getAttribute("value"));
        js.executeScript("document.querySelector('.heading-button', ':after').click();");
        js.executeScript("document.getElementById('deletebutton').click();");
        driver.findElement(By.cssSelector(".confirm")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//div/div[3]"));

    }


}
