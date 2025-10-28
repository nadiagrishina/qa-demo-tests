import java.time.Duration;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;


public class RegisteredUserLogin301Test {
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
    public void test301() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.get(Cfg.getSiteLink() + "/orders");

        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());
    }


}
