import java.time.Duration;

import org.bouncycastle.asn1.cmc.TaggedRequest;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ask20101Test {
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
    public void test20101() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".how-to-trigger")).click();
        driver.findElement(By.linkText("Ask question")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.id("questiontext")).click();
        driver.findElement(By.id("questiontext")).clear();
        driver.findElement(By.id("questiontext")).sendKeys("Test");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//input[@value='Send']")).click();

        Thread.sleep(2000);
        assertEquals("We will contact you within 2 business days", driver.findElement(By.xpath("//div[@id='askquestionfeedback']/div")).getText());
        driver.findElement(By.cssSelector("#askquestionfeedback .btn")).click();

    }


}
