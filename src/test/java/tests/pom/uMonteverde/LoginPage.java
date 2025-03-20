package tests.pom.uMonteverde;

import framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {


    @FindBy(id = "usuario")
    private WebElement user;

    @FindBy(id = "password")
    private WebElement pass;

    @FindBy(linkText = "Elementos")
    private WebElement elementos;

    @FindBy(id = "error-login")
    private WebElement errorLogin;
    @FindBy(css = "button[type='submit']")
    private WebElement btnAccept;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pass ) {
        setUser(user);
        setPass(pass);
        clickBtnAccept();
    }

    public boolean muestraErrorLogin(){
        return errorLogin.isDisplayed();
    }

    public boolean muestraMensajeDeBienvenida(){
        wait.until(ExpectedConditions.elementToBeClickable(elementos));
        return elementos.isDisplayed();
    }

    private void setUser(String user) {

        this.user.sendKeys(user);
    }


    private void setPass(String pass) {

        this.pass.sendKeys(pass);
    }

    private void clickBtnAccept() {
        this.btnAccept.click();
    }
    public void cleanInputs(){
        this.user.clear();
        this.pass.clear();
    }

}
