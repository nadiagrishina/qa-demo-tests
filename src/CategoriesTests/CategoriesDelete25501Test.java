import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;


import java.time.Duration;

public class CategoriesDelete25501Test {
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
    public void test25501Categories() throws Exception {
        String CATEGORY_NAME = "Public category 3";
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
        assertEquals("Public category 3 was successfully saved", driver.findElement(By.cssSelector(".alert:nth-child(3)")).getText());
        js.executeScript("document.querySelector('.heading-button', ':after').click();");
        js.executeScript("document.getElementById('deletebutton').click();");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".confirm")).click();
        Thread.sleep(1000);
        try {
            assertEquals("Category deleted!", driver.findElement(By.xpath("//div/div[2]")).getText());
        } catch (Error e) {
            BufferHelper.appendBuffer(e.toString());
        }
    }


}
