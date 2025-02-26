package framework.managers;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    public static void setupReport() {
        String reportName = "Report.html";
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + reportName);
            sparkReporter.config().setDocumentTitle("Consultoria Global Test Report");
            sparkReporter.config().setReportName("Banco Santander Report Functional");
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setEncoding("utf-8");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Computer Name", "localhost");
            extent.setSystemInfo("OS Name", System.getProperty("os.name"));
            extent.setSystemInfo("OS Version", System.getProperty("os.version"));
            extent.setSystemInfo("Environment", "Development");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
        }


    }

    public static ExtentTest createTestReport(String testName, String description) {
        ExtentTest test = extent.createTest(testName, description);
        testThread.set(test);
        return test;
    }

    public static ExtentTest getTest() {
        return testThread.get();
    }

    public static void flushTestReport() {
        if(extent != null) extent.flush();
    }

    public static ExtentTest createNode(String nodeName) {
        return getTest().createNode(nodeName);
    }
}
