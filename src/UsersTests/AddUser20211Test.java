import org.junit.*;


import java.time.Duration;

import org.openqa.selenium.*;

import static org.junit.Assert.fail;


public class AddUser20211Test {
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
    public void test20211() throws Exception {
        String USER_EMAIL = Cfg.getSaltString();
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".person__name > span")).click();
        driver.findElement(By.linkText("Users")).click();
        driver.findElement(By.linkText("Add user")).click();

        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys("User");
        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys(USER_EMAIL);
        driver.findElement(By.id("userPassword")).click();
        driver.findElement(By.id("userPassword")).clear();
        driver.findElement(By.id("userPassword")).sendKeys("qwerty123321");
        driver.findElement(By.id("sendButton")).click();

        driver.get(Cfg.getSiteLink() + "/myusers");

    }


}
