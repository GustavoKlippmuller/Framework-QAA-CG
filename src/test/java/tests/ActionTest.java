package tests;

import framework.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.nio.file.Paths;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ActionTest extends BaseTest {

    @BeforeMethod
    public void uploadPage() {
        String path = Paths.get("src/main/resources/actions.html").toUri().toString();
        driver.get(path);
    }

    @Test
    public void testMoveAllItems() {
        Actions actions = new Actions(driver);

        List<WebElement> elements = driver.findElements(By.cssSelector("#lista-origen .item"));

        List<String> textList = elements.stream()
                .map(WebElement::getText)
                .toList();

        WebElement destination = driver.findElement(By.id("lista-destino"));

        for (WebElement element : elements) {
            actions.clickAndHold(element)
                    .moveToElement(destination)
                    .release()
                    .perform();
        }


        elements = driver.findElements(By.cssSelector("#lista-origen .item"));
        assertEquals(elements.size(), 1);

        List<WebElement> destinationList = driver.findElements(By.cssSelector("#lista-destino .item"));
        List<String> destinationTextList = destinationList.stream()
                .map(WebElement::getText)
                .toList();

        assertEquals(destinationTextList, textList);
    }

    @Test
    public void testMoveItem() {
        Actions actions = new Actions(driver);
        List<WebElement> elements = driver.findElements(By.cssSelector("#lista-origen .item"));
        WebElement caba = elements.get(0);
        WebElement destination = driver.findElement(By.id("lista-destino"));
        actions.clickAndHold(caba)
                .moveToElement(destination)
                .release()
                .perform();

        List<WebElement> destinationList = driver.findElements(By.cssSelector("#lista-destino .item"));
        assertEquals(destinationList.size(), 1);
        assertEquals(destinationList.get(0).getText(), "Ciudad Autonoma de Buenos Aires");
    }
}
