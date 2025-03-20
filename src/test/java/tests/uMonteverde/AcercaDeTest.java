package tests.uMonteverde;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.pom.AcercaPage;
import tests.pom.uMonteverde.AcercaDePage;
import tests.pom.uMonteverde.BuscarElementosPage;
import tests.pom.uMonteverde.LoginPage;
import tests.pom.uMonteverde.Menu;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AcercaDeTest extends BaseTest  {


    private AcercaDePage acd;

    @BeforeClass
    public void setup() {

        LoginPage lgn = new LoginPage(driver);
        waitExplicitFiveSeconds();
        lgn.login("admin", "1234");
        Menu mn = new Menu(driver);
        waitExplicitFiveSeconds();
        mn.clickearBuscarElementos();
        waitExplicitFiveSeconds();
        BuscarElementosPage bep = new BuscarElementosPage(driver);
        bep.irAotroSitioClick();
        acd = new AcercaDePage(driver);
    }


    @Test()
    @TestName("Muestra nombre")
    public void muestraNombre(){
        assertTrue(acd.getNombre());
    }

    @Test()
    @TestName("Verifica nombre")
    public void VerificaNombre(){
        assertEquals(acd.getContentNombre(),"Gustavo Klippmüller");
    }


    @Test()
    @TestName("Muestra Posicion")
    public void muestraPosicion(){
        assertTrue(acd.getPosicion());
    }

    @Test()
    @TestName("Verifica Posicion")
    public void VerificaPosicion(){
        assertEquals(acd.getContentPosicion(),"QA Automation");
    }


    @Test()
    @TestName("Muestra compania")
    public void muestraCompania(){
        assertTrue(acd.getCompania());
    }

    @Test()
    @TestName("Verifica compania")
    public void VerificaCompania(){
        assertEquals(acd.getContentCompania(),"Consultoria Global");
    }


    @Test()
    @TestName("Imagen existe")
    public void existeImg(){
        assertTrue(acd.getImg());
    }




}
