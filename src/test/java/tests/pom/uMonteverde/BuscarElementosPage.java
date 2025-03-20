package tests.pom.uMonteverde;

import framework.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BuscarElementosPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Práctica: Búsqueda de Elementos']")
    private WebElement tituloBusquedaDeElementos;

    @FindBy(xpath = "//label[text()='Usuario']")
    private WebElement labelUsuario;

    @FindBy(name = "elemento-name")
    private WebElement inputName;

    @FindBy(xpath = "//label[text()='Contraseña']")
    private WebElement labelContrasenia;

    @FindBy(id = "elemento-id")
    private WebElement inputId;

    @FindBy(xpath = "//label[text()='Botón con CLASS:']")
    private WebElement labelBoton;

    @FindBy(id = "clickButton")
    private WebElement clickButton;

    @FindBy(id = "selectedOptionLabel")
    private WebElement selectedOptionLabel;

    @FindBy(id = "selectedOptionLabel")
    private WebElement optionLabel;

    @FindBy(xpath = "//div[@class='input-group']//div[@id='dateDiv' and contains(text(), 'Fecha actual:')]\n")
    private WebElement labelFechaActual;

    @FindBy(id = "dateDiv")
    private WebElement dateDiv;

    @FindBy(xpath = "//label[text()='Enlace con CSS Selector:']\n")
    private WebElement labelCssSelector;

    @FindBy(linkText = "Ir a otro sitio")
    private WebElement otroSitio;

    public BuscarElementosPage(WebDriver driver) {
        super(driver);
    }
    private Alert alert;


    public String getTituloBusquedaDeElementos(){
        return this.tituloBusquedaDeElementos.getText();
    }


    public boolean getBusquedaDeElementos(){
        return tituloBusquedaDeElementos.isDisplayed();
    }

    public String getLabelContentUsuario(){
        return this.labelUsuario.getText();
    }
    public boolean getLabelUsuario(){
        return labelUsuario.isDisplayed();
    }
    public boolean getInputId(){
        return inputId.isDisplayed();
    }

    public String getlabelContentContrasenia(){
        return this.labelContrasenia.getText();
    }
    public boolean getLabelContrasenia(){
        return labelContrasenia.isDisplayed();
    }
    public boolean getInputName(){
        return inputName.isDisplayed();
    }

    public String getLabelContentBoton(){
        return this.labelBoton.getText();
    }

    public boolean getLabelBoton(){
        return labelBoton.isDisplayed();
    }
    public boolean getSendButton(){
        return clickButton.isDisplayed();
    }

    public String getLabelContentOption(){
        return this.selectedOptionLabel.getText();
    }

    public boolean getLabelOption(){
        return selectedOptionLabel.isDisplayed();
    }

    public String getLabelContentDate(){
        return this.labelFechaActual.getText();
    }

    public boolean getLabelDate(){
        return labelFechaActual.isDisplayed();
    }
    public boolean getDateDiv(){
        return dateDiv.isDisplayed();
    }

    public boolean getFechaActual(){
        String textoDiv = dateDiv.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String fechaActual = sdf.format(new Date());
        return textoDiv.contains(fechaActual);
    }


    public String getLabelContentCssSelector(){
        return this.labelCssSelector.getText();
    }

    public boolean getLabelCssSelector(){
        return labelCssSelector.isDisplayed();
    }

    public boolean getButtonOtroSitio(){
        return otroSitio.isDisplayed();
    }

    public void irAotroSitioClick(){
        otroSitio.click();
    }

    public void hacerClick(){
        clickButton.click();
    }

    public String getAlertText() {
        return alert.getText();
    }

    public boolean alertIsPresent(){
        if(shortWait.until(ExpectedConditions.alertIsPresent()) != null) {
            alert = driver.switchTo().alert();
            return true;
        }
        return false;
    }
    public void acceptAlert() {
        alert.accept();
    }

    public void cancelAlert() {
        alert.dismiss();
    }

    public String getLblAlertOption() {
        return this.optionLabel.getText();
    }

}

