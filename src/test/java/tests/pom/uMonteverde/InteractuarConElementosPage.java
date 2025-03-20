package tests.pom.uMonteverde;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InteractuarConElementosPage extends BasePage {

    @FindBy(id = "firstname")
    private WebElement firstName;


    @FindBy(id = "lastname")
    private WebElement lastname;

    @FindBy(id = "dropdown")
    private WebElement documentoType;


    @FindBy(id = "admin")
    private WebElement checkBoxAdmin;

    @FindBy(id = "manager")
    private WebElement checkBoxManager;

    @FindBy(id = "colaborator")
    private WebElement checkBoxColaborator;

    @FindBy(id = "reader")
    private WebElement checkBoxReader;
    @FindBy(id = "guest")
    private WebElement checkBoxGuest;

    @FindBy(id = "virtual")
    private WebElement radioVirtual;

    @FindBy(id = "hibrido")
    private WebElement radioHibrido;

    @FindBy(id = "presencial")
    private WebElement radioPresencial;

    public InteractuarConElementosPage(WebDriver driver) {
        super(driver);
    }

    public void interactFirstName(String text) {
        firstName.sendKeys(text);
    }

    public String getFirstName() {
        return firstName.getAttribute("value");
    }


    public void interactSecondName(String text) {
        lastname.sendKeys(text);
    }

    public String getSecondName() {
        return lastname.getAttribute("value");
    }


    public void selectOptions(int index) {
        Select selectDocumentType = new Select(documentoType);
        selectDocumentType.selectByIndex(index);
    }

    public String getSelectOptions() {
        return documentoType.getAttribute("value");
    }

    public void clickAdmin() {
        checkBoxAdmin.click();
    }

    public boolean stateAdmin() {
        return checkBoxAdmin.isSelected();
    }

    public void clickManager() {
        checkBoxManager.click();
    }


    public boolean stateManager() {
        return checkBoxManager.isSelected();
    }


    public void clickColaborator() {
        checkBoxColaborator.click();
    }


    public boolean stateColaborator() {
        return checkBoxColaborator.isSelected();
    }


    public void clickReader() {
        checkBoxReader.click();
    }


    public boolean stateReader(){
        return checkBoxReader.isSelected();
    }

    public void clickGuest(){
        checkBoxGuest.click();
    }


    public boolean stateGuest(){
        return checkBoxGuest.isSelected();
    }

    public void clickRadioVirtual(){
        radioVirtual.click();
    }

    public boolean getStateRadioVirtual(){
        return radioVirtual.isSelected();
    }

    public void clickRadioHibrido(){
        radioHibrido.click();
    }

    public boolean getStateRadiHibrido(){
        return radioHibrido.isSelected();
    }


    public void clickRadioPresencial(){
        radioPresencial.click();
    }

    public boolean getStateRadioPresencial(){
        return radioPresencial.isSelected();
    }

}
