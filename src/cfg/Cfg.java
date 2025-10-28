import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;

public class Cfg {
    private static WebDriver driver;
    private static String driverpath = ".\\chromedriver\\chromedriver";
    private static String siteLink = "https://admin.test.com";
    private static String portalLink = "https://test.test.com/";
    private static final boolean HEADLESS = true;

    public static WebDriver getDriver() {
        if (Cfg.driver == null) {
            System.setProperty("webdriver.chrome.driver", driverpath);
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.setHeadless(HEADLESS);
            options.addArguments("--window-size=1600,900");
            driver = new ChromeDriver(options);
            return driver;
        } else {
            if (((RemoteWebDriver) driver).getSessionId() == null) {
                Cfg.driver = null;
                Cfg.getDriver();
            }
            return driver;
        }
    }

    public static String getDriverpath() {
        return driverpath;
    }

    public static String getSiteLink() {
        return siteLink;
    }

    public static String getPortalLink() {
        return portalLink;
    }

    public static String getSaltString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@maill1.com";
    }

    public static void Authorization() {
        driver = getDriver();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("test@test.test");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("testtest");
        driver.findElement(By.cssSelector(".btn")).click();
    }

    public static void createDirectoryIfNotExists(String dirName) {
        File theDir = new File(dirName);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }
}

