import java.time.Duration;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;


public class CategoriesEditCategory25301Test {
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
    public void test25301Categories() throws Exception {
        String CATEGORY_NAME_OLD = "internet-shop";
        String CATEGORY_NAME = "internet-shop.new";
        String CATEGORY_SORT = "500";
        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.linkText("Categories")).click();
        assertEquals("Categories", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.id("name_field")).sendKeys(CATEGORY_NAME_OLD);
        driver.findElement(By.cssSelector(".btn-md")).click();
        driver.findElement(By.linkText("internet-shop.new")).click();
        assertEquals("Update category", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys(CATEGORY_NAME);
        driver.findElement(By.cssSelector(".filter-option-inner-inner")).click();
        driver.findElement(By.name("sort")).clear();
        driver.findElement(By.name("sort")).sendKeys(CATEGORY_SORT);
        String categorySort = (String) driver.findElement(By.name("sort")).getAttribute("value");
        driver.findElement(By.cssSelector(".d-inline-flex > #dropdownMenuButton")).click();
        categorySort = driver.findElement(By.name("sort")).getAttribute("value");
        try {
            assertEquals(CATEGORY_NAME, driver.findElement(By.name("name")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }

        try {
            assertEquals(CATEGORY_SORT, categorySort);
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
