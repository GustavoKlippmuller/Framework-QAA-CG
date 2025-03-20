package tests.pom;

import framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class TablesPage extends BasePage {

    @FindBy(css = "iframe")
    private WebElement iFrame;

    @FindBy(tagName = "table")
    private WebElement table;

    private final By columns = By.xpath(".//thead/tr/th");

    public TablesPage(WebDriver driver) {
        super(driver);
    }

    public int getAmountColumns() {
        switchToIframe();
        List<WebElement> columns = table.findElements(this.columns);
        switchToDefaultContent();
        return columns.size();
    }

    public List<String> getHeaders() {
        switchToIframe();
        List<WebElement> headerElements = table.findElements(this.columns);
        List<String> headers = new ArrayList<>();
        for (WebElement header : headerElements) {
            headers.add(header.getText().trim());
        }
        switchToDefaultContent();
        return headers;
    }

    public List<List<String>> getRows() {
        switchToIframe();
        List<WebElement> rowElements = table.findElements(By.xpath(".//tbody/tr"));
        List<List<String>> rows = new ArrayList<>();

        for (WebElement row : rowElements) {
            List<WebElement> fieldsElements = row.findElements(By.tagName("td"));
            List<String> rowData = new ArrayList<>();

            for (WebElement field : fieldsElements) {
                rowData.add(field.getText().trim());
            }
            rows.add(rowData);
        }
        switchToDefaultContent();
        return rows;
    }

    private void switchToIframe() {
        wait.until(ExpectedConditions.elementToBeClickable(iFrame));
        driver.switchTo().frame(iFrame);
    }

    private void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }


}
