import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class AdditionalUserLogin21Test {
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
    public void test21() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".person__name > span")).click();
        driver.findElement(By.linkText("Users")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.linkText("Add user")).click();

        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys("User");
        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys("grishina07111@gmail.com");
        driver.findElement(By.id("userPassword")).click();
        driver.findElement(By.id("userPassword")).clear();
        driver.findElement(By.id("userPassword")).sendKeys("qwerty56!");
        driver.findElement(By.id("sendButton")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get(Cfg.getSiteLink() + "/logout/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("grishina07111@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("qwerty56!");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);

        assertEquals("Dashboard", driver.findElement(By.cssSelector("h1")).getText());
    }


}
