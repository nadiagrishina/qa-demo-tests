import org.junit.*;
import org.openqa.selenium.*;

import static org.junit.Assert.fail;


public class ChangeEmailToExist150012Test {
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
    public void test150012() throws Exception {

        driver.get(Cfg.getSiteLink() + "/logout/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("test");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("testtest");
        driver.findElement(By.cssSelector(".btn")).click();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(6) .nav-item__img")).click();
        driver.findElement(By.xpath("//div[2]/div/div/div/a")).click();
        driver.findElement(By.cssSelector(".item:nth-child(2) > .btn")).click();
        driver.findElement(By.name("customer-new-email")).clear();
        driver.findElement(By.name("customer-new-email")).sendKeys("alexey1@testtest.net");
        driver.findElement(By.id("customer-new-pswd")).click();
        driver.findElement(By.id("customer-new-pswd")).clear();
        driver.findElement(By.id("customer-new-pswd")).sendKeys("testtest");
        driver.findElement(By.cssSelector(".controls > .btn-primary")).click();
        driver.findElement(By.cssSelector(".heading-button")).click();

    }


}
