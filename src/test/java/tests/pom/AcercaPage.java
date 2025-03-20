package tests.pom;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AcercaPage extends BasePage {

    @FindBy(tagName = "h1")
    private WebElement title;
    public AcercaPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }
}
