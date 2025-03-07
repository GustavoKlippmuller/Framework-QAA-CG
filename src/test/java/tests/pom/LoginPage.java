package tests.pom;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "usuario")
    private WebElement user;

    @FindBy(id = "password")
    private WebElement pass;

    @FindBy(css = "button[type='submit']")
    private WebElement btnAccept;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        setUser();
        setPass();
        clickBtnAccept();
    }

    private void setUser() {
        this.user.sendKeys("admin");
    }

    private void setPass() {
        this.pass.sendKeys("1234");
    }

    private void clickBtnAccept() {
        this.btnAccept.click();
    }

}
