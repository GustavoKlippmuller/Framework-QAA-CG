package framework.base;

import com.aventstack.extentreports.ExtentTest;
import framework.annotations.TestName;
import framework.managers.ReportManager;
import framework.utils.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public abstract class BaseTest {

    protected WebDriver driver;
    protected String browser;
    protected String language;
    protected JavascriptExecutor js;
    private ExtentTest node;
    private ExtentTest report;

    @BeforeTest
    @Parameters({"browser", "environment", "language", "headless"})
    public void setup(String browser, @Optional String environment, @Optional String language, String headless) {
        this.browser = browser;
        this.language = language;
        driver = WebDriverFactory.getWebDriver(browser, headless);
        ReportManager.setupReport();
    }

    @BeforeClass
    public void setupClass() {
        report = ReportManager.createTestReport(this.getClass().getSimpleName(), getDescription());
    }

    @BeforeMethod
    public void setupMethod(Method method) {
        node = ReportManager.createNode(getTestName(method.getName()));
    }

    @AfterTest
    public void tearDown() {
        ReportManager.flushTestReport();
    }

    protected String getDescription() {
        return "Descripcion por defecto";
    }

    private String getTestName(String methodName) {
        try {
            TestName annotation = this.getClass().getMethod(methodName).getAnnotation(TestName.class);
            return (annotation != null) ? annotation.value() : methodName;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return "Unknow Test";
        }
    }

    protected ExtentTest getNode() {
        return node;
    }
}
