import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class PlaceAnOrderOpenLeft21001Test {
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
    public void test21001PlaceAnOrder() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.xpath("//div[2]/a/img")).click();
        driver.get(Cfg.getSiteLink() + "/neworder");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        assertEquals("Place new order", driver.findElement(By.cssSelector("h1")).getText());
    }


}
