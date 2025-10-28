import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;


public class ProductsTitlesTest {
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
    public void testProductsTitles() throws Exception {
        String Product1 = "Iphone 2";
        String Product2 = "New product";
        String Product3 = "Ordered product";

        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys(Product1, Keys.ENTER);
        driver.findElement(By.linkText(Product1)).click();
        assertEquals("test - Iphone 2", driver.getTitle());

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(Product2, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.linkText(Product2)).click();
        assertEquals("test - New product", driver.getTitle());

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(Product3, Keys.ENTER);
        driver.findElement(By.linkText(Product3)).click();
        assertEquals("test - Ordered product", driver.getTitle());
    }


}
