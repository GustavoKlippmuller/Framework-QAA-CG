package tests.uMonteverde;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.pom.uMonteverde.LoginPage;
import tests.pom.uMonteverde.Menu;
import tests.pom.uMonteverde.ValidarTablasPage;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class ValidarTablasTest extends BaseTest {

    private ValidarTablasPage vtbp;
    @BeforeClass
    public void setup() {
        LoginPage lg = new LoginPage(driver);
        lg.login("admin","1234");
        Menu mn = new Menu(driver);
        mn.clickearValidarTablas();
        vtbp = new ValidarTablasPage(driver);
        vtbp.swtichIframe();

    }

    @Test()
    @TestName("La tabla tiene 4 columnas")
    public void getCantidadDeColmunas(){
        assertEquals(vtbp.getCantidadColumnas(),4);
    }

    @Test()
    @TestName("Cantidad de usuarios")
    public void getCantidadDeUsuarios() throws InterruptedException {
        vtbp.volverAlaPrimeraPagina();
        waitExplicitFiveSeconds();
        assertEquals(vtbp.getCantidadUsuarios(),25);
    }

    @Test()
    @TestName("Cantidad de paginas")
    public void getCantidadDePaginas(){
        waitExplicitFiveSeconds();
        assertEquals(vtbp.getCantidadPaginas(),3);
    }

    @Test()
    @TestName("Boton siguiente ")
    public void getBotonSiguiente(){
        assertEquals(vtbp.getBotonSiguiente(),"Siguiente");
    }

    @Test()
    @TestName("Boton Anterior ")
    public void getBotonAnterior(){
        assertEquals(vtbp.getBotonAnterior(),"Anterior");
    }

    @Test()
    @TestName("Verificar que Carolina Suarez existe ")
    public void existeCarolinaSuarez() throws InterruptedException {
        vtbp.volverAlaPrimeraPagina();
        assertEquals(vtbp.getCarolinaSuarez(),true);
    }

}
