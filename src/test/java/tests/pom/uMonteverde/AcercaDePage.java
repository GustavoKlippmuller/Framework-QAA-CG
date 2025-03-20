package tests.pom.uMonteverde;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AcercaDePage extends BasePage {

    @FindBy(xpath = "//h2[text()='Acerca de']\n")
    private WebElement acercaDeLabel;

    @FindBy(className = "imagen" )
    private WebElement img;

    @FindBy(className = "nombre")
    private WebElement nombre;

    @FindBy(className = "posicion")
    private WebElement posicion;

    @FindBy(className = "compania")

    private WebElement compania;

    public AcercaDePage(WebDriver driver) {
        super(driver);
    }



    public boolean getH2Label(){
        return acercaDeLabel.isDisplayed();
    }


    public String getContentH2Label(){
        return acercaDeLabel.getText();
    }

    public boolean getImg(){
        return img.isDisplayed();
    }

    public boolean getNombre(){
        return nombre.isDisplayed();
    }

    public String getContentNombre(){
        return nombre.getText();
    }

    public boolean getPosicion(){
        return posicion.isDisplayed();
    }

    public String getContentPosicion(){
        return posicion.getText();
    }

    public boolean getCompania(){
        return compania.isDisplayed();
    }

    public String getContentCompania(){
        return compania.getText();
    }

}
