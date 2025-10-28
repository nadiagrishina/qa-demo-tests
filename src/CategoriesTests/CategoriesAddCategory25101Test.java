import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;

public class CategoriesAddCategory25101Test {
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
    public void test25101Categories() throws Exception {
        String CATEGORY_NAME = "Public category";
        int CATEGORY_SORT = 110;

        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__img")).click();
        assertEquals("Products", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.linkText("Categories")).click();
        assertEquals("Categories", driver.findElement(By.cssSelector("h1")).getText());
        driver.findElement(By.linkText("Add category")).click();
        assertEquals("Add category", driver.findElement(By.cssSelector("h1")).getText());

        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys(CATEGORY_NAME);
        String categoryName = driver.findElement(By.name("name")).getAttribute("value");
        driver.findElement(By.cssSelector(".filter-option-inner-inner")).click();
        driver.findElement(By.name("sort")).clear();
        driver.findElement(By.name("sort")).sendKeys(String.valueOf(CATEGORY_SORT));
        String categorySort = driver.findElement(By.name("sort")).getAttribute("value");

        driver.findElement(By.cssSelector(".d-inline-flex > #dropdownMenuButton")).click();
        assertEquals("Public category was successfully saved", driver.findElement(By.cssSelector(".alert:nth-child(3)")).getText());

        try {
            assertEquals(categorySort, driver.findElement(By.name("sort")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
        try {
            assertEquals(categoryName, driver.findElement(By.name("name")).getAttribute("value"));
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
