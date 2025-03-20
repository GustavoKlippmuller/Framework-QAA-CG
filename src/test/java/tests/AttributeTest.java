package tests;

import framework.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.nio.file.Paths;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AttributeTest extends BaseTest {

    @BeforeClass
    public void uploadPage() {
        String path = Paths.get("src/main/resources/acceptPage.html").toUri().toString();
        driver.get(path);
    }

    @Test
    public void testForms() {

        WebElement form = driver.findElement(By.tagName("form"));
        String acceptForm = form.getDomAttribute("accept");
        assertEquals(acceptForm, "application/pdf, application/msword");

        String actionForm = form.getDomAttribute("action");
        assertEquals(actionForm, "/upload");

        String autocompleteForm = form.getDomAttribute("autocomplete");
        assertEquals(autocompleteForm, "on");

        String methodForm = form.getDomAttribute("method");
        assertEquals(methodForm, "POST");

        String enctypeForm = form.getDomAttribute("enctype");
        assertEquals(enctypeForm, "multipart/form-data");
    }

    @Test
    public void testInputs() {

        WebElement accept = driver.findElement(By.id("cv"));
        String acceptInput = accept.getDomAttribute("accept");
        assertEquals(acceptInput, ".pdf,.doc,.docx");
        assertEquals(accept.getDomAttribute("name"), "cv");
        assertEquals(accept.getDomAttribute("required"), "true");

        WebElement firstname = driver.findElement(By.id("firstname"));
        String autocompleteInput = firstname.getDomAttribute("autocomplete");
        assertEquals(autocompleteInput, "family-name");
        assertEquals(firstname.getDomAttribute("placeholder"), "Nombre completo");

        String autofocus = firstname.getDomAttribute("autofocus");
        assertEquals(autofocus, "true");
        assertEquals(firstname.getDomAttribute("data-test"), "firstname");

        WebElement tac = driver.findElement(By.id("tac"));
        assertTrue(tac.isSelected());
        assertEquals(tac.getDomAttribute("checked"), "true");
        assertEquals(tac.getDomAttribute("class"), "terms");

        WebElement lastname = driver.findElement(By.id("apellido"));
        assertEquals(lastname.getDomAttribute("list"), "apellidos");
        assertEquals(lastname.getDomAttribute("maxlength"), "50");

        WebElement color = driver.findElement(By.id("color"));
        assertEquals(color.getDomAttribute("readonly"), "true");
        assertEquals(color.getDomAttribute("title"), "Dato de muestra obligatorio");
    }

    @Test
    public void testBody() {
        WebElement body = driver.findElement(By.tagName("body"));
        String rgbaColor = body.getCssValue("background-color");
        assertEquals(rgbaColor, "rgba(191, 171, 62, 1)");
    }

    @Test
    public void testTable() {
        WebElement table = driver.findElement(By.tagName("table"));
        WebElement thead = table.findElement(By.tagName("thead"));
        WebElement tr = thead.findElement(By.tagName("tr"));
        List<WebElement> ths = tr.findElements(By.tagName("th"));
        WebElement th = ths.get(0);
        System.out.println(driver.findElement(By.id("one")).getCssValue("border-style"));
        System.out.println(th.getCssValue("border-width"));
        System.out.println(th.getCssValue("border-color"));
        WebElement tbody = table.findElement(By.tagName("tbody"));
        WebElement trs = tbody.findElements(By.tagName("tr")).get(0);
        WebElement field = trs.findElements(By.tagName("td")).iterator().next();
        assertEquals(field.getDomAttribute("headers"), "one");

    }

    @Test
    public void testLabel() {
        WebElement label = driver.findElement(By.id("label-tac"));
        assertEquals(label.getCssValue("color"), "rgba(3, 21, 108, 1)");
        assertEquals(label.getDomAttribute("for"), "firstname");

        WebElement hiddenLabel = driver.findElement(By.className("error"));
        assertEquals(hiddenLabel.getDomAttribute("hidden"), "true");
    }

    @Test
    public void testSelect() {
        WebElement select = driver.findElement(By.id("type"));
        WebElement option = select.findElements(By.tagName("option")).get(0);
        assertEquals(option.getDomAttribute("disabled"), "true");

        WebElement food = driver.findElement(By.id("food"));
        assertEquals(food.getDomAttribute("multiple"), "true");
    }

    @Test
    public void testButton() {
        WebElement button = driver.findElement(By.tagName("button"));
        assertEquals(button.getDomAttribute("form"), "myForm");
        assertEquals(button.getCssValue("height"),"50px");
        assertEquals(button.getCssValue("width"),"200px");
    }

    @Test
    public void testLink() {
        WebElement link = driver.findElement(By.tagName("a"));
        assertEquals(link.getDomAttribute("href"), "getText.html");
        assertEquals(link.getDomAttribute("id"), "thisIsAnId");
    }

    @Test
    public void testMeter() {
        WebElement meter = driver.findElement(By.id("fuel"));
        assertEquals(meter.getDomAttribute("high"), "66");
        assertEquals(meter.getDomAttribute("low"), "33");
        assertEquals(meter.getDomAttribute("max"), "100");
        assertEquals(meter.getDomAttribute("min"), "0");
        assertEquals(meter.getDomAttribute("value"), "25");
    }

    @Test
    public void testImage() {
        WebElement image = driver.findElement(By.tagName("img"));
        assertEquals(image.getDomAttribute("src"), "getText.html");
    }

}
