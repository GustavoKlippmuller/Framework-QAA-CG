package tests.pom.uMonteverde;

import framework.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LlenarFormularioPage extends BasePage {

    public LlenarFormularioPage(WebDriver driver ){
        super(driver);
    }

    @FindBy(id = "nombre")
    private WebElement nombreInput;

    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "error-email")
    private WebElement emailIncompleto;


    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "error-password")
    private WebElement errorPassword;


    @FindBy(id = "edad")
    private WebElement edadInput;
    @FindBy(id = "error-edad")
    private WebElement errorEdad;

    @FindBy(id = "fecha")
    private WebElement fechaInput;


    @FindBy(xpath = "//form[@id='formulario']//button")
    private WebElement button;







    public void enterInputName(String text){
        nombreInput.sendKeys(text);
    }
    public void limpiarInputName() {
        nombreInput.clear();
    }
    public String getInputName(){
        return nombreInput.getAttribute("value");
    }


    public void enterInputEmal(String text) {
        emailInput.sendKeys(text);
    }
    public void limpiarInputEmail() {
        emailInput.clear();
    }
    public String getInputEmail(){
        return emailInput.getAttribute("value");
    }



    public void enterInputPassword(String text){
        passwordInput.sendKeys(text);
    }
    public void limpiarInputPassword() {
        passwordInput.clear();
    }
    public String getInputPassword(){
        return passwordInput.getAttribute("value");
    }
    public boolean getErrorPassword(){
        return errorPassword.isDisplayed();
    }



    public void inputEdad(int edad){
        edadInput.sendKeys(String.valueOf(edad));
    }
    public void limpiarInputEdad() {
        edadInput.sendKeys(Keys.CONTROL + "a");
        edadInput.sendKeys(Keys.DELETE);
    }
    public int getInputEdad(){
        return Integer.parseInt(edadInput.getAttribute("value"));
    }

    public boolean getErrorEdad(){
        return errorEdad.isDisplayed();
    }



    public void inputFecha(String fecha) {
        fechaInput.sendKeys(fecha);
    }
    public void limpiarInputFecha() {
        fechaInput.clear();
    }
    public String getFecha() {
        return fechaInput.getAttribute("value");
    }



    public void clickButon(){
        button.click();
    }


    public String getMensajeContraseñaIncompleta(){
        return passwordInput.getAttribute("validationMessage");
    }
    public String getMensajeEmailIncompleta(){
        return emailInput.getAttribute("validationMessage");
    }
    public String getMensajeFechaIncompleta(){
        return fechaInput.getAttribute("validationMessage");
    }

    public String getMensajeEdadIncompleta(){
        return edadInput.getAttribute("validationMessage");
    }








}
