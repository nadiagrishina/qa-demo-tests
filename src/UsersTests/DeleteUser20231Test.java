import org.junit.*;


import java.time.Duration;

import org.openqa.selenium.*;

import static org.junit.Assert.fail;


public class DeleteUser20231Test {
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
    public void test20231() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".person__name > span")).click();
        driver.findElement(By.linkText("Users")).click();
        driver.findElement(By.linkText("Add user")).click();

        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("userName")).sendKeys("Test User");
        driver.findElement(By.id("userEmail")).sendKeys("test.test@yandex.ru");
        driver.findElement(By.id("userPassword")).click();
        driver.findElement(By.id("userPassword")).sendKeys("asdfghj");
        driver.findElement(By.id("sendButton")).click();


        driver.get(Cfg.getSiteLink() + "/myusers");

        driver.findElement(By.xpath("(//div[@id='dataTable']/div[2]/div/div[8]/div[4]/a")).click();

        assertEquals("test.test@yandex.ru", driver.findElement(By.id("userEmail")).getText());
        driver.findElement(By.xpath("//div[@id='editModal']/div/div/div/button/span")).click();

        driver.findElement(By.cssSelector(".tabulator-row:nth-child(8) .fa")).click();
        driver.switchTo().alert().accept();
    }


}
