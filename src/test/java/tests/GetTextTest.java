package tests;

import framework.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetTextTest extends BaseTest {

    @BeforeClass
    public void uploadPage() {
        String path = Paths.get("src/main/resources/getText.html").toUri().toString();
        driver.get(path);
    }
    @Test
    public void testGetTextHeaders() {
        String title = driver.findElement(By.id("title")).getText();
        assertEquals(title, "Main Title");
        String subtitle = driver.findElement(By.id("subtitle")).getText();
        assertEquals(subtitle, "Secondary title" );
    }

    @Test
    public void testParagraph() {
        String text = driver.findElement(By.tagName("p")).getText();
        assertTrue(text.contains("Lorem ipsum dolor sit amet"));
    }

    @Test
    public void testDiv() {
        String text = driver.findElement(By.id("deep")).getText();
        assertEquals(text, "This is a text in a div");
    }

    @Test
    public void testSpan() {
        String text = driver.findElement(By.tagName("span")).getText();
        assertEquals(text, "This is a span text");
    }

    @Test
    public void testList() {
        List<String> expectedItems = Arrays.asList("Item 1", "Item 2");
        List<WebElement> elements = driver.findElements(By.tagName("li"));
        List<String> actualItems = elements.stream()
                .map(WebElement::getText)
                .toList();
        assertEquals(actualItems, expectedItems);
    }

    @Test
    public void testButton() {
        String text = driver.findElement(By.id("button")).getText();
        assertEquals(text, "Click here");
    }

    @Test
    public void testLink() {
        String text = driver.findElement(By.id("myLink")).getText();
        assertEquals(text, "Link to page");
    }
}
