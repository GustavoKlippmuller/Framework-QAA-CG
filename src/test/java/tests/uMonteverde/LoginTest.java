package tests.uMonteverde;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.pom.uMonteverde.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {
    private LoginPage lgp;

    @BeforeClass
    public void setup(){
        lgp = new LoginPage(driver);
    }


    @Test()
    @TestName("No deja iniciar sesion al usuario con una contraseña erronea")
    public void muestraMensajeDeErrorPorContraseña() {
            lgp.login("admin", "12345");
            assertTrue(lgp.muestraErrorLogin());
    }

    @Test()
    @TestName("No deja iniciar sesion al usuario con un uusario erroneo")
    public void muestraMensajeDeErrorPorUsuario() {
        lgp.login("user", "1234");
        assertTrue(lgp.muestraErrorLogin());
    }


    @Test()
    @TestName("No deja iniciar sesion al usuario con un usuario y contraseña erroneo")
    public void muestraMensajeDeErrorPorUsuarioYcontraseña() {
        lgp.login("user", "12345");
        assertTrue(lgp.muestraErrorLogin());
    }

    @Test()
    @TestName("Permite iniciar sesion con credenciales correctas")
    public void permiteIniciarSesion(){
        lgp.cleanInputs();
        lgp.login("admin","1234");
        assertTrue(lgp.muestraMensajeDeBienvenida());
    }

}
