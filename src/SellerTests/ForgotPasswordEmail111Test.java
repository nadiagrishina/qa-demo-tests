import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


import java.time.Duration;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class ForgotPasswordEmail111Test {
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
    public void test111Email() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get(Cfg.getSiteLink() + "/logout/");

        driver.findElement(By.cssSelector(".forgot-link")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("alexey.testtest222@yandex.ru");
        driver.findElement(By.cssSelector(".btn-primary")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        assertEquals("If this email address exists, you will get a password reset email.", driver.findElement(By.cssSelector(".alert")).getText());
    }


}
