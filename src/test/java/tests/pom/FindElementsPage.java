package tests.pom;

import framework.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindElementsPage extends BasePage {

    @FindBy(id = "clickButton")
    private WebElement btnAccept;

    @FindBy(id = "selectedOptionLabel")
    private WebElement optionLabel;

    private Alert alert;
    public FindElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickBtnAccept() {
        this.btnAccept.click();
    }

    public boolean alertIsPresent() {
        if(shortWait.until(ExpectedConditions.alertIsPresent()) != null) {
            alert = driver.switchTo().alert();
            return true;
        }
        return false;
    }

    public String getAlertText() {
        return  alert.getText();
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
