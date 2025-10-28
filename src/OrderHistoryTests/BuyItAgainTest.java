import java.time.Duration;
import java.util.ArrayList;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;


public class BuyItAgainTest {
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
    public void testBuyItAgainTest() throws Exception {
        String COMPANY_NAME = "123";
        String CUSTOMER_PRODUCT_1 = "Ordered product";
        String CUSTOMER_PRICE_PRODUCT_1 = "100";
        String CUSTOMER_PRODUCT_2 = "Removable product";
        String CUSTOMER_PRICE_PRODUCT_2 = "200";
        String CUSTOMER_COUNT_PRODUCT_1 = "30";
        String CUSTOMER_COUNT_PRODUCT_2 = "20";
        driver.get(Cfg.getSiteLink() + "/logout");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("test");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("testtest");
        driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(2) .nav-item__name")).click();
        assertEquals("Order history", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.cssSelector(".btn-bright")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        assertEquals("Place new order", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.cssSelector(".show > .bs-searchbox > .form-control")).sendKeys(COMPANY_NAME);
        driver.findElement(By.cssSelector(".bs-searchbox > .form-control")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.cssSelector(".product_item_select .filter-option-inner-inner")).click();
        driver.findElement(By.cssSelector(".show .form-control")).sendKeys(CUSTOMER_PRODUCT_1, Keys.ENTER);
        driver.findElement(By.name("price[]")).clear();
        driver.findElement(By.name("price[]")).sendKeys(CUSTOMER_PRICE_PRODUCT_1);
        driver.findElement(By.name("quantity[]")).clear();
        driver.findElement(By.name("quantity[]")).sendKeys(CUSTOMER_COUNT_PRODUCT_1);
        driver.findElement(By.cssSelector(".bs-placeholder .filter-option-inner-inner")).click();
        driver.findElement(By.cssSelector(".show .form-control")).sendKeys(CUSTOMER_PRODUCT_2, Keys.ENTER);
        driver.findElement(By.xpath("//tr[2]/td[5]/div/input")).sendKeys(CUSTOMER_PRICE_PRODUCT_2);
        driver.findElement(By.xpath("//tr[2]/td[6]/div/input")).clear();
        driver.findElement(By.xpath("//tr[2]/td[6]/div/input")).sendKeys(CUSTOMER_COUNT_PRODUCT_2);
        driver.findElement(By.cssSelector(".heading-button")).click();
        Thread.sleep(2000);
        js.executeScript("var a = document.getElementsByClassName('dropdown-item');a[a.length - 4].click();");
        Thread.sleep(5000);
        tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(2));
        Thread.sleep(5000);
        assertEquals("Place new order", driver.findElement(By.cssSelector("h1")).getText());
    }


}


