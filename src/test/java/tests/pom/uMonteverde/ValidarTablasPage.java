package tests.pom.uMonteverde;

import framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class ValidarTablasPage extends BasePage {



    @FindBy(tagName = "iframe")
    private WebElement iframe;

    @FindBy(xpath = "//table[@id='tabla-personas']/tbody/tr")
    private List<WebElement> userRows;

    @FindBy(tagName = "th")
    private List<WebElement> columns ;
    @FindBy(tagName = "tr")
    private List<WebElement> rows;

    @FindBy(xpath = "//button[text()='Anterior']")
    private WebElement butonAtras;

    @FindBy(tagName = "td")
    private List<WebElement> fields;

    @FindBy(xpath = "//button[text()='Siguiente']")
    private WebElement botonSiguiente;

    public void volverAlaPrimeraPagina(){
        int index = 0;
        while(index < 3 ){
            butonAtras.click();
            index++;
        }
    }

    public ValidarTablasPage(WebDriver driver ){
        super(driver);
    }


    public int getCantidadColumnas(){
        return columns.size();
    }


    public String getBotonSiguiente(){
        return botonSiguiente.getText();
    }

    public String getBotonAnterior(){
        return butonAtras.getText();
    }
    public int getCantidadUsuarios() throws InterruptedException {
        int index = 0;
        int cantUsers = 0;
        while (index < 3) {
            for(WebElement row:userRows){
                cantUsers++;
                System.out.println(row.getText());
            }
            try {
                if (botonSiguiente.isEnabled()) {
                    botonSiguiente.click();
                    index++;

                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return cantUsers;
    }


    public boolean getCarolinaSuarez() throws InterruptedException {
        int index = 0;
        int cantUsers = 0;
        boolean existe = false;
        while (index < 3) {
            for(WebElement row:userRows){
                if(row.getText().contains("Carolina Suárez 25 Chubut")){
                    existe = true;
                    System.out.println(existe);
                }
            }
            try {
                if (botonSiguiente.isEnabled()) {
                    botonSiguiente.click();
                    index++;

                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
        System.out.println(existe);
        return existe;
    }

    public int getCantidadPaginas(){
        int index = 0;
        int pages = 0;
        while (index < 3) {
            try {
                if (botonSiguiente.isEnabled()) {
                    pages++;
                    botonSiguiente.click();
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
            index++;
        }
        return pages;
    }


    public void swtichIframe(){
        driver.switchTo().frame(iframe);
    }




}
