package tests;

import framework.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.pom.MainPage;

import java.time.Duration;
import java.util.Objects;

public class InteractTest extends BaseTest {

    @Test
    public void test() {
        driver.findElement(By.id("usuario")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.tagName("button")).click();
        waitForLoadingEnd();

        new MainPage(driver).setElementInteract();
        waitForLoadingEnd();

        driver.findElement(By.id("admin")).click();
        waitExplicitFiveSeconds();
        driver.findElement(By.id("admin")).clear();
        waitExplicitFiveSeconds();
    }

    private void waitForLoadingEnd() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until((ExpectedCondition<Boolean>) wd ->
        {
            assert wd != null;
            return Objects.equals(((JavascriptExecutor) wd).executeScript("return document.readyState"), "complete");
        });
    }

}

