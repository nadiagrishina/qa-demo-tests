import org.junit.*;


import java.time.Duration;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;


public class RemoveProductTest {
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
    public void testRemoveProduct() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();

        driver.findElement(By.cssSelector(".nav-list-item:nth-child(4) .nav-item__name")).click();
        driver.findElement(By.linkText("Add product")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Removable !!!!! product");
        driver.findElement(By.name("new_product_option[0][retail_price]")).click();
        driver.findElement(By.name("new_product_option[0][retail_price]")).sendKeys("100");
        driver.findElement(By.cssSelector(".heading-button")).click();
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.heading-button', ':after').click();");
        js.executeScript("document.getElementById('deletebutton').click();");
        driver.findElement(By.cssSelector(".confirm")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div/div[3]"));
        assertEquals("Product deleted!", driver.findElement(By.cssSelector(".alert:nth-child(4)")).getText());
    }


}
