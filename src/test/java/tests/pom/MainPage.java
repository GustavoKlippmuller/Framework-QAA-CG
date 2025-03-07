package tests.pom;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[text()='Elementos']")
    private WebElement elements;

    @FindBy(xpath = "//a[normalize-space()='Formulario']")
    private WebElement forms;

    @FindBy(css = "a[href='busqueda_elementos.html']")
    private WebElement elementsFind;

    @FindBy(css = "a[href='interactuar_elementos.html']")
    private WebElement elementsInteract;

    @FindBy(css = "a[href='validar_tablas.html']")
    private WebElement formsTables;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void selectElementFinds() {
        this.selectElements();
        this.elementsFind.click();
    }

    public void setElementInteract() {
        this.selectElements();
        this.elementsInteract.click();
    }

    public void selectFormsTable() {
        this.selectForms();
        this.formsTables.click();
    }

    private void selectElements() {
        shortWait.until(ExpectedConditions.elementToBeClickable(elements));
        this.elements.click();
    }

    private void selectForms() {
        shortWait.until(ExpectedConditions.elementToBeClickable(forms));
        this.forms.click();
    }
}
