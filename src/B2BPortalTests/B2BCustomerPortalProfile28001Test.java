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
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class B2BCustomerPortalProfile28001Test {
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
    public void test28001B2BCustomerPortalProfile() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        Cfg.Authorization();

        driver.findElement(By.cssSelector(".person__icon")).click();
        driver.findElement(By.linkText("Profile")).click();
        assertEquals("Profile", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.linkText(Cfg.getPortalLink())).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        driver.findElement(By.linkText("Dashboard"));
    }


}
