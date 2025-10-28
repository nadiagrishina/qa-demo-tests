import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProfileTheSameAsBillingAddress20302Test {
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
    public void test20302ProfileTheSameAsBillingAddress() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".person__icon")).click();
        driver.findElement(By.linkText("Profile")).click();
        assertEquals("Profile", driver.findElement(By.cssSelector("h1")).getText());
        WebElement checkbox = driver.findElement(By.id("billing-address-switch"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".heading-button"))).click();
        try {
            assertEquals(true, driver.findElement(By.id("billing-address-switch")).isSelected());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
