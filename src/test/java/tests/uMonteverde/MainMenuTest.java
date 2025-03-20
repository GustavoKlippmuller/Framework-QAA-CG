package tests.uMonteverde;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.pom.uMonteverde.LoginPage;
import tests.pom.uMonteverde.Menu;

import static org.testng.AssertJUnit.assertTrue;

public class MainMenuTest extends BaseTest {

    private Menu mMenu;

    @BeforeClass
    public void setup() {
        LoginPage logt = new LoginPage(driver);
        logt.login("admin","1234");
        mMenu = new Menu(driver);
    }

    @Test()
    @TestName("Existe Elementos")
    public void getElementos(){
        assertTrue(mMenu.getElementos());
    }

    @Test()
    @TestName("Existe Buscar Elementos")
    public void getBuscarElementos(){
        assertTrue(mMenu.getBuscarElementos());
    }

    @Test()
    @TestName("Existe Interactuar Elementos")
    public void getInteractuarElementos(){
        assertTrue(mMenu.getInteractuarElementos());
    }

    @Test()
    @TestName("Existe Formulario")
    public void getFormlario(){
        assertTrue(mMenu.getFormulario());
    }

    @Test()
    @TestName("Existe llenar formulario")
    public void getLlenarFormulario(){
        assertTrue(mMenu.getllenarFormulario());
    }

    @Test()
    @TestName("Existe validar tablas")
    public void getValidarTablas(){
        assertTrue(mMenu.getvalidarTablas());
    }

    @Test()
    @TestName("Existe cerrar sesion")
    public void getCerrarSesion(){
        assertTrue(mMenu.getCerrarSesion());
    }

}



