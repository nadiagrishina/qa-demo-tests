import org.junit.*;


import java.time.Duration;

import org.openqa.selenium.*;

import static org.junit.Assert.fail;


public class AddUserExistingEmail20221Test {
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
    public void test20221AddUserExistingEmail() throws Exception {
        String USER_EMAIL;
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".person__name > span")).click();
        driver.findElement(By.linkText("Users")).click();
        USER_EMAIL = driver.findElement(By.cssSelector(".tabulator-row:nth-child(2) > .tabulator-cell:nth-child(2)")).getText();
        driver.findElement(By.linkText("Add user")).click();

        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys("TestAlex");
        driver.findElement(By.id("userEmail")).click();
        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys(USER_EMAIL);
        driver.findElement(By.id("userPassword")).click();
        driver.findElement(By.id("userPassword")).clear();
        driver.findElement(By.id("userPassword")).sendKeys("asdfghj");
        driver.findElement(By.id("sendButton")).click();

        driver.findElement(By.id("errorMessage")).getText();
    }


}
