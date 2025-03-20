package tests.pom;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

public class PrincipalPage extends BasePage {

    @FindBy(tagName = "h1")
    private WebElement title;

    @FindBy(css = ".boton")
    private WebElement boton;

    @FindBy(id = "username")
    private WebElement inputUsername;

    @FindBy(name = "curso")
    private WebElement selectCurso;

    @FindBy(name = "color")
    private List<WebElement> radioColor;

    @FindBy(name = "tyc")
    private WebElement checkTyC;

    @FindBy(name = "fecha")
    private WebElement date;

    @FindBy(name = "fechaHora")
    private WebElement datetime;

    public PrincipalPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAcercaDe() {
        boton.click();
    }

    public void fillInputUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void selectCurso(String curso) {
        Select cursoSelect = new Select(selectCurso);
        cursoSelect.selectByVisibleText(curso);
    }

    public void chooseColor(String color) {
        for(WebElement element : radioColor) {
            if(Objects.equals(element.getDomProperty("value"), color))
                element.click();
        }
    }

    public void checkTermConditions() {
        if(!checkTyC.isSelected()) checkTyC.click();
    }

    public void uncheckTermConditions() {
        if(checkTyC.isSelected()) checkTyC.click();
    }

    public void fillDate(String date) {
        this.date.sendKeys(date);
    }

    public void fillDatetime(String datetime) {
        js.executeScript("arguments[0].value = '" + datetime + "';", this.datetime);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getInputUsernameText() {
        return inputUsername.getDomProperty("value");
    }

    public String getSelectedCurso() {
        Select selectCurso = new Select(this.selectCurso);
        return selectCurso.getFirstSelectedOption().getText();
    }

    public String getSelectedColor() {
        for(WebElement element : radioColor) {
            if(element.isSelected())
                return element.getDomAttribute("value");
        }
        return "";
    }

    public Boolean getStatusTyC() {
        return checkTyC.isSelected();
    }

}
