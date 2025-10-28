import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;


public class CouponsFullNameSearch23021Test {
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
    public void test23021Coupons() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(3) .nav-item__img")).click();
        assertEquals("Coupons", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("promo");
        WebElement element = driver.findElement(By.xpath("//button[contains(.,'Apply')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        Object isRightResult = js.executeScript("let tabl = document.getElementsByClassName('tabulator-cells');filterField = document.getElementsByClassName('name').value;let l = []; let w = 0;for (let i = 0; i<tabl.length;i = i + 6){l[w] = tabl[i]; w++;}for(let i =0; i< l.length; i++){let a = l[i].firstChild;if (a != filterField)return false;}return true;").toString();
        try {
            assertEquals("true", isRightResult);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

    }


}
