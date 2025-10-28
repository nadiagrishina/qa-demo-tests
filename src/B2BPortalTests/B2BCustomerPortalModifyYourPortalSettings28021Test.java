import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class B2BCustomerPortalModifyYourPortalSettings28021Test {
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
    public void test28021B2BCustomerPortalModifyYourPortalSettings() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".header__personal > #dropdownMenuButton")).click();
        driver.findElement(By.linkText("Settings")).click();
        assertEquals("Settings", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.xpath("//div[2]/div/div/a")).click();
        driver.findElement(By.linkText("Modify your portal")).click();
        try {
            assertEquals("Your portal preview", driver.findElement(By.cssSelector("h1")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }

}
