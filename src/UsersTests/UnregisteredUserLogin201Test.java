import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;

public class UnregisteredUserLogin201Test {
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
    public void test201() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.get(Cfg.getSiteLink() + "/home");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());

        driver.get(Cfg.getSiteLink() + "/dashboard");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());

        driver.get(Cfg.getSiteLink() + "/profile");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());

        driver.get(Cfg.getSiteLink() + "/neworder");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());

        driver.get(Cfg.getSiteLink() + "/orders");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/orders/209/edit");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/orders/209/clone");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/orders/208/void");

        driver.get(Cfg.getSiteLink() + "/coupons");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/coupons/11/edit");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());

        driver.get(Cfg.getSiteLink() + "/products");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/products/158/edit");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/products/export");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/products/import");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());

        driver.get(Cfg.getSiteLink() + "/customers");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/customers/7/edit");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/orders?customer=%D0%BF%D1%80%D0%B2%D1%8B%D0%BF%D1%80");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());

        driver.get(Cfg.getSiteLink() + "/reports");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/reports/sales");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/reports/customers");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/reports/products");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/reports/commissions");
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());

        driver.get(Cfg.getSiteLink() + "/settings");

        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
    }


}
