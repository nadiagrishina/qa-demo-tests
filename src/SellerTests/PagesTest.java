import org.junit.*;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.*;

public class PagesTest {
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
    public void testPagesTest() throws Exception {
        driver.get(Cfg.getSiteLink() + "/logout/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Cfg.Authorization();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        String[][] Pages = {
                {Cfg.getSiteLink() + "/dashboard", "Dashboard"},
                {Cfg.getSiteLink() + "/profile", "Profile"},
                {Cfg.getSiteLink() + "/profile/subscriptions/plans", "Subscription plans"},
                {Cfg.getSiteLink() + "/myusers", "Users"},
                {Cfg.getSiteLink() + "/settings", "Settings"},
                {Cfg.getPortalLink() + "categories", "Categories"},
                {Cfg.getSiteLink() + "/profile/subscriptions/invoices", "Billing"},
                {Cfg.getSiteLink() + "/settings/terms", "Terms of Service"},
                {Cfg.getSiteLink() + "/admin", "Admin area"},
                {Cfg.getSiteLink() + "/products", "Products"},
                {Cfg.getSiteLink() + "/neworder", "Place new order"},
                {Cfg.getSiteLink() + "/orders", "Order history"},
                {Cfg.getSiteLink() + "/coupons", "Coupons"},
                {Cfg.getSiteLink() + "/reports", "Reports"},
                {Cfg.getSiteLink() + "/orders/export", "Export orders"},
                {Cfg.getSiteLink() + "/coupons/create", "Add coupon"},
                {Cfg.getSiteLink() + "/products/create", "Add product"},
                {Cfg.getSiteLink() + "/products/export", "Export products"},
                {Cfg.getSiteLink() + "/products/import", "Import products"},
                {Cfg.getSiteLink() + "/categories", "Categories"},
                {Cfg.getSiteLink() + "/categories/create", "Add category"},
                {Cfg.getSiteLink() + "/customers/create", "Add customer"},
                {Cfg.getSiteLink() + "/customers/export", "Export customers"},
                {Cfg.getSiteLink() + "/customers/import", "Import customers"},
                {Cfg.getSiteLink() + "/customers/commissions", "Commission for Reps"},
                {Cfg.getSiteLink() + "/customers/commissions/create", "Add Commission plan"},
                {Cfg.getSiteLink() + "/emails", "Emails"},
                {Cfg.getSiteLink() + "/emails/templates", "Email templates"},
                {Cfg.getSiteLink() + "/emails/newtemplate", "Create template"},
                {Cfg.getSiteLink() + "/reports/sales", "Sales Report"},
                {Cfg.getSiteLink() + "/reports/customers", "Sales By Customer Report"},
                {Cfg.getSiteLink() + "/reports/products", "Sales By Product Report"},
                {Cfg.getSiteLink() + "/reports/statements", "Commission Statements"},
                {Cfg.getSiteLink() + "/reports/commissions_new", "Commission Report"},
                {Cfg.getSiteLink() + "/notification", "Notifications"},
                {Cfg.getSiteLink() + "/customers", "Customers"},
                {Cfg.getSiteLink() + "/terms_of_service", "Terms of service"}

        };

        for (int i = 0; i < Pages.length; i++) {
            driver.get(Pages[i][0]);
            try {
                assertEquals(Pages[i][1], driver.findElement(By.cssSelector("h1")).getText());
            } catch (AssertionError e) {
                System.out.println("Error");
                System.out.println(Pages[i][0]);
            }

        }

    }


}
