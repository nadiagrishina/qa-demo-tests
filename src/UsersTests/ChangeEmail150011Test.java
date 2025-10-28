import org.junit.*;
import org.openqa.selenium.*;

import static org.junit.Assert.fail;


public class ChangeEmail150011Test {
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
    public void test150011() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("test");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("testtest");
        driver.findElement(By.cssSelector(".btn")).click();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(6) .nav-item__img")).click();
        driver.findElement(By.name("company_name")).click();
        driver.findElement(By.name("company_name")).sendKeys("re");
        driver.findElement(By.cssSelector(".field > .btn")).click();
        driver.findElement(By.linkText("re")).click();
        driver.findElement(By.linkText("Credentials")).click();
        driver.findElement(By.name("customer-new-email")).clear();
        driver.findElement(By.name("customer-new-email")).sendKeys("test8952@test.com");
        driver.findElement(By.id("customer-new-pswd")).click();
        driver.findElement(By.id("customer-new-pswd")).clear();
        driver.findElement(By.id("customer-new-pswd")).sendKeys("12345678911");
        driver.findElement(By.cssSelector(".controls > .btn-primary")).click();
        driver.findElement(By.cssSelector(".heading-button")).click();

        driver.findElement(By.cssSelector(".person__name > span")).click();
        driver.findElement(By.linkText("Log Out")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("test8952@test.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456789");
        driver.findElement(By.cssSelector(".btn")).click();
        assertEquals("My account", driver.findElement(By.cssSelector(".person__name > span")).getText());
    }


}
