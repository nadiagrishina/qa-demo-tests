import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProductsEditNegative24302Test {
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        driver = Cfg.getDriver();
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void test24302Products() throws Exception {
        String PRODUCT_NAME = "Test";
        String DEPTH = "-100";
        String BARCODE = "12345";
        String SUP_CODE = "456";
        String SKU = "123";
        String WIDTH = "-200";
        String HEIGHT = "-400";
        String WEIGHT = "-700";
        String SORT = "-100";
        String STOCK_AVIABLE = "-100";
        String RETAIL = "-120";
        String VIP = "-110";
        String WHOLESALE = "-90";
        String COST = "-110";
        String OPTION_1 = "option 1";

        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("test");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("testtest");
        driver.findElement(By.cssSelector(".btn")).click();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.id("name")).sendKeys(PRODUCT_NAME, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.linkText(PRODUCT_NAME)).click();

        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(PRODUCT_NAME);
        driver.findElement(By.id("SKU")).clear();
        driver.findElement(By.id("SKU")).sendKeys(SKU);
        driver.findElement(By.id("supplier-code")).clear();
        driver.findElement(By.id("supplier-code")).sendKeys(SUP_CODE);
        driver.findElement(By.id("barcode")).clear();
        driver.findElement(By.id("barcode")).sendKeys(BARCODE);
        driver.findElement(By.id("depth")).clear();
        driver.findElement(By.id("depth")).sendKeys(DEPTH);
        driver.findElement(By.id("width")).clear();
        driver.findElement(By.id("width")).sendKeys(WIDTH);
        driver.findElement(By.id("height")).clear();
        driver.findElement(By.id("height")).sendKeys(HEIGHT);
        driver.findElement(By.id("weight")).clear();
        driver.findElement(By.id("weight")).sendKeys(WEIGHT);
        driver.findElement(By.id("sort")).clear();
        driver.findElement(By.id("sort")).sendKeys(SORT);

        driver.findElement(By.id("add-option")).click();
        driver.findElement(By.cssSelector("td > .form-control:nth-child(2)")).sendKeys(OPTION_1);
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(2) > .form-control")).clear();
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(2) > .form-control")).sendKeys(SORT);
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(3) > .form-control")).clear();
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(3) > .form-control")).sendKeys(STOCK_AVIABLE);
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(4) > .form-control")).clear();
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(4) > .form-control")).sendKeys(RETAIL);
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(5) > .form-control")).clear();
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(5) > .form-control")).sendKeys(VIP);
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(6) > .form-control")).clear();
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(6) > .form-control")).sendKeys(WHOLESALE);
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(7) > .form-control")).clear();
        driver.findElement(By.cssSelector("tr:nth-child(1) > .product-option-column:nth-child(7) > .form-control")).sendKeys(COST);

        driver.findElement(By.cssSelector(".heading-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.navigate().refresh();
    }
}
