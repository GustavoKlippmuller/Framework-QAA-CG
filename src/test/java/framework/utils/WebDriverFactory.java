package framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Objects;

public class WebDriverFactory {

    public static WebDriver getWebDriver(String browser, String headless) {
        WebDriver driver = null;
        switch (browser) {
            case "chrome":
                ChromeOptions coptions = new ChromeOptions();
                coptions.addArguments("--incognito");
                if(Objects.equals(headless,"si")) {
                    coptions.addArguments("--headless");
                    coptions.addArguments("--disable-gpu");
                    coptions.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(coptions);
                driver.manage().window().maximize();
                break;
            case "edge":
                EdgeOptions eoptions = new EdgeOptions();
                if(Objects.equals(headless,"si")) {
                    eoptions.addArguments("--headless");
                    eoptions.addArguments("--disable-gpu");
                    eoptions.addArguments("--window-size=1920,1080");
                }
                driver = new EdgeDriver(eoptions);
        }
        return driver;
    }
}
