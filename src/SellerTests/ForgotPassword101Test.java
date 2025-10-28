import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class ForgotPassword101Test {
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
    public void test101() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".person__name > span")).click();
        driver.findElement(By.linkText("Users")).click();

        String CUSTOMER_EMAIL = driver.findElement(By.cssSelector(".tabulator-row:nth-child(2) > .tabulator-cell:nth-child(2)")).getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.get(Cfg.getSiteLink() + "/logout/");

        driver.findElement(By.cssSelector(".forgot-link")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(CUSTOMER_EMAIL);
        driver.findElement(By.cssSelector(".btn-primary")).click();

        assertEquals("If this email address exists, you will get a password reset email.", driver.findElement(By.cssSelector(".alert")).getText());

    }


}
