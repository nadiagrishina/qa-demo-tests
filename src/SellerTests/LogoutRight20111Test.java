import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class LogoutRight20111Test {
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
    public void test20111Logout() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get(Cfg.getSiteLink());
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".person__name > span")).click();
        driver.findElement(By.linkText("Log Out")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
        driver.get(Cfg.getSiteLink() + "/orders/");


        assertEquals("Login to your account", driver.findElement(By.cssSelector(".form-title")).getText());
    }


}
