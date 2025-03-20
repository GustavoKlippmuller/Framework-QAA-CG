package tests.uMonteverde;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.pom.FindElementsPage;
import tests.pom.MainPage;
import tests.pom.uMonteverde.BuscarElementosPage;
import tests.pom.uMonteverde.LoginPage;
import tests.pom.uMonteverde.Menu;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertTest extends BaseTest {

    private BuscarElementosPage bcp;

    @BeforeClass
    public void setup() {
        LoginPage lgn = new LoginPage(driver);
        lgn.login("admin","1234");
        Menu mmn = new Menu(driver);
        mmn.clickearBuscarElementos();
        bcp = new BuscarElementosPage(driver);
    }


    @BeforeMethod
    public void loadDriver() {
        bcp.hacerClick();
        assertTrue(bcp.alertIsPresent());
    }



    @Test()
    @TestName("Testea el accept del alert")
    public void alertAccept(){
        assertEquals("¿Aceptas términos y condiciones? Haz clic en Aceptar o Cancelar.", bcp.getAlertText());
        bcp.acceptAlert();
        assertEquals("Opción seleccionada: Aceptar", bcp.getLblAlertOption());
    }


    @Test
    @TestName("Verificar que pueda cancelar el alerta")
    public void testCancelAlert() {
        bcp.cancelAlert();
        assertEquals("Opción seleccionada: Cancelar", bcp.getLblAlertOption());
    }


}
