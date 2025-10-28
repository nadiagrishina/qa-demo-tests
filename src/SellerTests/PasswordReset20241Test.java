import org.junit.*;


import java.time.Duration;

import org.openqa.selenium.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class PasswordReset20241Test {
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
    public void test20241() throws Exception {
        String USER_EMAIL = "alexey1.testtest@yandex.ru";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get(Cfg.getSiteLink() + "/logout/");

        driver.findElement(By.cssSelector(".forgot-link")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(USER_EMAIL);
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertEquals("If this email address exists, you will get a password reset email.", driver.findElement(By.cssSelector(".alert")).getText());

    }


}
