package tests;

import framework.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.time.Duration;

public class InteractElementsTest extends BaseTest {

    @BeforeClass
    public void uploadPage() {
        String path = Paths.get("src/main/resources/interactElements.html").toUri().toString();
        driver.get(path);
    }

    @Test
    public void interactSlidersTest() {
        WebElement slider = driver.findElement(By.id("slider"));
        for (int i = 0; i < 10; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    @Test
    public void interactDatePickerTest() {
        WebElement datePicker = driver.findElement(By.id("date-picker"));
        datePicker.clear();
        datePicker.sendKeys("14-03-2025");
    }

    @Test
    public void interactColorPickerTest() {
        WebElement colorPicker = driver.findElement(By.id("color-picker"));
        colorPicker.sendKeys("#000");
    }

    @Test
    public void interactSwitchesTest() {
        WebElement toggleSwitch = driver.findElement(By.id("toggle-switch"));
        if (!toggleSwitch.isSelected()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", toggleSwitch);
        }
    }

    @Test
    public void interactAutocompleteTest() {
        WebElement comboBox = driver.findElement(By.id("combo-box"));
        comboBox.sendKeys("Opción 1");
        comboBox.sendKeys(Keys.ENTER);
    }

    @Test
    public void interactRichTextTest() {
        driver.switchTo().frame("mce_0_ifr");
        WebElement editorBody = driver.findElement(By.tagName("body"));
        editorBody.clear();
        editorBody.sendKeys("Este es un texto de prueba en TinyMCE.");
        driver.switchTo().defaultContent();
    }

    @Test
    public void interactModalTest() {
        driver.findElement(By.id("btnModal")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal")));
        WebElement closeBtn = modal.findElement(By.className("close"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", closeBtn);

    }
}
