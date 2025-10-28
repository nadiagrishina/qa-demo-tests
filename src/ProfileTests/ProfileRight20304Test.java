import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class ProfileRight20304Test {
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
    public void test20304Profile() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".person__icon")).click();
        driver.findElement(By.linkText("Profile")).click();
        assertEquals("Profile", driver.findElement(By.cssSelector("h1")).getText());
    }


}
