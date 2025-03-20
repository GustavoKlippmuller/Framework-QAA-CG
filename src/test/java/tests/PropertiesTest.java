package tests;

import framework.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class PropertiesTest extends BaseTest {

    @Test
    public void testPropertiesAndAttribute() {
        String path = Paths.get("src/main/resources/PageBasic.html").toUri().toString();
        driver.get(path);
        WebElement input = driver.findElement(By.id("miInput"));
        WebElement span = driver.findElement(By.id("miTexto"));

        System.out.println("getAttribute('value'): " + input.getDomAttribute("value")); // "ValorInicial"
        System.out.println("getDomAttribute('placeholder'): " + input.getDomAttribute("placeholder")); // "Escribe aquí"
        System.out.println("getDomProperty('value'): " + input.getDomProperty("value")); // "ValorInicial"
        System.out.println("getAttribute('data-custom'): " + input.getDomAttribute("data-custom")); // "datoPersonalizado"
        System.out.println("getText(): " + span.getText()); // "Texto Visible"


        waitExplicitFiveSeconds();
    }
}
