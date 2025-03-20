package tests;

import framework.base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestONE extends BaseTest {

    @Test
    public void test_uno() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.id("usuario")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.tagName("button")).click();

        WebElement menuElementos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Elementos']")));
        if (menuElementos != null) {
            menuElementos.click();
            driver.findElement(By.cssSelector("a[href='busqueda_elementos.html']")).click();
        }
        waitExplicitFiveSeconds();
        driver.findElement(By.id("clickButton")).click();
        waitExplicitFiveSeconds();



        if(wait.until(ExpectedConditions.alertIsPresent())!=null) {
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            System.out.println(driver.findElement(By.id("selectedOptionLabel")).getText());
        }

    }




}
