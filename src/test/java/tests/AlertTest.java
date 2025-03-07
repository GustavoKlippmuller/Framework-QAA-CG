package tests;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.pom.FindElementsPage;
import tests.pom.LoginPage;
import tests.pom.MainPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertTest extends BaseTest {

    private FindElementsPage page;

    @Override
    protected String getDescription() {
        return "Este test verifica el funcionamiento del alert";
    }

    @BeforeClass
    public void setupLogin() {
        new LoginPage(driver).login();
        new MainPage(driver).selectElementFinds();
    }

    @BeforeMethod
    public void loadDriver() {
        page = new FindElementsPage(driver);
        page.clickBtnAccept();
        assertTrue(page.alertIsPresent());
    }

    @Test
    @TestName("Verificar que pueda aceptar el alerta")
    public void testAcceptAlert() {
        assertEquals("¿Aceptas términos y condiciones? Haz clic en Aceptar o Cancelar.", page.getAlertText());
        page.acceptAlert();
        assertEquals("Opción seleccionada: Aceptar", page.getLblAlertOption());
    }

    @Test
    @TestName("Verificar que pueda cancelar el alerta")
    public void testCancelAlert() {
        page.cancelAlert();
        assertEquals("Opción seleccionada: Cancelar", page.getLblAlertOption());
    }
}
