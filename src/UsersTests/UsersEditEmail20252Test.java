import org.junit.*;


import org.openqa.selenium.*;

import static org.junit.Assert.fail;


public class UsersEditEmail20252Test {
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
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("test");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("testtest");
        driver.findElement(By.cssSelector(".btn")).click();

        driver.findElement(By.cssSelector(".person__name > span")).click();
        driver.findElement(By.linkText("Profile")).click();
        assertEquals("Company info", driver.findElement(By.cssSelector("h1")).getText());
        assertEquals("test - Company info", driver.getTitle());

        driver.findElement(By.id("email-field")).clear();
        driver.findElement(By.id("email-field")).sendKeys("test21@test.ru");
        driver.findElement(By.cssSelector(".heading-button")).click();

        driver.findElement(By.cssSelector(".person__name > span")).click();
        driver.findElement(By.linkText("Users")).click();
        driver.findElement(By.cssSelector(".tabulator-row:nth-child(1) .fas")).click();
        driver.findElement(By.id("userEmail")).click();
        driver.findElement(By.id("userEmail")).clear();
        String new_email = Cfg.getSaltString();
        driver.findElement(By.id("userEmail")).sendKeys(new_email);
        driver.findElement(By.id("sendButton")).click();

        driver.findElement(By.cssSelector(".person__name > span")).click();
        driver.findElement(By.linkText("Profile")).click();
        assertEquals(new_email, driver.findElement(By.name("email")).getAttribute("value"));
    }


}
