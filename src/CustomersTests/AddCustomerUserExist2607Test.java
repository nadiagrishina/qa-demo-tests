import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class AddCustomerUserExist2607Test {
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
    public void test2607Customers() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".person__name > span")).click();
        driver.findElement(By.linkText("Users")).click();

        String CUSTOMER_EMAIL = driver.findElement(By.cssSelector(".tabulator-row:nth-child(2) > .tabulator-cell:nth-child(2)")).getText();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(5) .nav-item__img")).click();
        assertEquals("Customers", driver.findElement(By.xpath("//div[2]/h1")).getText());
        assertEquals("test - Customers", driver.getTitle());

        driver.findElement(By.linkText("Add customer")).click();

        driver.findElement(By.name("company_name")).clear();
        driver.findElement(By.name("company_name")).sendKeys("testtest");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(CUSTOMER_EMAIL);
        driver.findElement(By.name("first_name")).sendKeys("First name");
        driver.findElement(By.name("last_name")).sendKeys("Last name");
        driver.findElement(By.cssSelector(".heading-button")).click();
        driver.findElement(By.name("shipping_address")).sendKeys("qwerty");
        driver.findElement(By.name("shipping_city")).sendKeys("qwerty");
        driver.findElement(By.name("shipping_state")).sendKeys("qwerty");
        driver.findElement(By.name("shipping_postal_code")).sendKeys("qwerty12");
        driver.findElement(By.name("shipping_country")).sendKeys("qwerty");

        driver.findElement(By.cssSelector(".heading-button")).click();
        driver.findElement(By.cssSelector(".alert-danger"));

    }


}

