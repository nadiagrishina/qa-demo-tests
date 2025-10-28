import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class UsersEdit20251Test {
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
    public void test20251Users() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".person__name > span")).click();
        driver.findElement(By.linkText("Users")).click();
        assertEquals("Users", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.cssSelector(".tabulator-row:nth-child(7) .fa-pencil")).click();
        driver.findElement(By.id("userName")).click();
        String userName = (String) driver.findElement(By.id("userName")).getAttribute("value");
        if (userName.toString() == "User") {
            driver.findElement(By.id("userName")).clear();
            driver.findElement(By.id("userName")).sendKeys("Alexey");
        } else {
            driver.findElement(By.id("userName")).clear();
            driver.findElement(By.id("userName")).sendKeys("Alex");
        }
        driver.findElement(By.id("userEmail")).click();
        String userEmail = (String) driver.findElement(By.id("userEmail")).getAttribute("value");
        if (userEmail.toString() == "test.user@yandex.ru") {
            driver.findElement(By.id("userEmail")).clear();
            driver.findElement(By.id("userEmail")).sendKeys("test2357@test.ru");
        } else {
            driver.findElement(By.id("userEmail")).clear();
            driver.findElement(By.id("userEmail")).sendKeys("alexey1.testtest@yandex.ru");
        }
        userEmail = (String) driver.findElement(By.id("userEmail")).getAttribute("value");
        driver.findElement(By.id("userPassword")).click();

        driver.findElement(By.id("userPassword")).sendKeys("12As8Ujll01");

        String userPassword = (String) driver.findElement(By.id("userPassword")).getAttribute("value");

        driver.findElement(By.id("sendButton")).click();

        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get(Cfg.getSiteLink() + "/login");

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(userEmail);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(userPassword);
        driver.findElement(By.cssSelector(".btn")).click();
        driver.get(Cfg.getSiteLink() + "/dashboard");


    }


}
