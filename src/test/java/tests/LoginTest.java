package tests;

import framework.base.BaseTest;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LoginTest extends BaseTest {

    @Test
    public void test() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");

        Set<String> windows = driver.getWindowHandles();
        List<String> listWindows = new ArrayList<>(windows);

        driver.switchTo().window(listWindows.get(1));
        driver.get("https://www.google.com");

//        waitExplicitFiveSeconds();
//        driver.switchTo().window(listWindows.get(0));
//        waitExplicitFiveSeconds();
//
//        driver.switchTo().window(listWindows.get(1));
//        waitExplicitFiveSeconds();

        driver.close();
        driver.switchTo().window(listWindows.get(0));

        WebDriver googleWindows = driver.switchTo().newWindow(WindowType.WINDOW);
        googleWindows.get("https://www.google.com.ar");

        googleWindows.findElement(By.cssSelector("textarea[title='Buscar']")).sendKeys("Asana");

        waitExplicitFiveSeconds();
//        windows = driver.getWindowHandles();
//        listWindows = new ArrayList<>(windows);

//        driver.switchTo().window(listWindows.get(0));
//        waitExplicitFiveSeconds();
//
//        driver.switchTo().window(listWindows.get(1));
//        waitExplicitFiveSeconds();
//
        googleWindows.close();
        waitExplicitFiveSeconds();

    }
}
