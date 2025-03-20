package tests.pom.gklippmuller;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends BasePage {

    @FindBy(linkText = "Elementos")
    public WebElement elementos;

    @FindBy(linkText = "Buscar Elementos")
    public WebElement buscarElementos;

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    public boolean elementosIsPresent() {
        return elementos.isDisplayed();
    }

    public boolean buscarElementosIsPresent() {
        return buscarElementos.isDisplayed();
    }
}
