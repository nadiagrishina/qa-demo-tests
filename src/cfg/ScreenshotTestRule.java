import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import static org.junit.Assert.fail;


public class ScreenshotTestRule implements TestRule {
    WebDriver driver;
    private StringBuffer verificationErrors = BufferHelper.returnCurrentBuffer();

    public ScreenshotTestRule() {
        this.driver = Cfg.getDriver();
    }

    public Statement apply(final Statement statement, final Description description) {
        String className = description.getTestClass().getSimpleName();
        String methodName = description.getMethodName();

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable t) {
                    getScreenshot(className, methodName);
                    throw t;
                }
                finally {
                    String verificationErrorString = verificationErrors.toString();
                    if (!"".equals(verificationErrorString)) {
                        getScreenshot(className, methodName);
                        fail(verificationErrorString);
                    }
                    tearDown();
                }
            }
        };
    }

    public void getScreenshot(String className, String methodName) throws IOException {
        String currentDate = DateHelper.getCurrentDate();
        String currentTime = DateHelper.getCurrentTime();
        String fileName = currentDate + "/" + className;
        Cfg.createDirectoryIfNotExists("errorScreenshots");
        Cfg.createDirectoryIfNotExists("errorScreenshots/" + currentDate);
        Cfg.createDirectoryIfNotExists("errorScreenshots/" + fileName);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("errorScreenshots/" + fileName + "/" + methodName + "_" + currentTime + ".png"));
    }

    public void tearDown() throws Exception {
        driver.quit();
    }
}