package tests.uMonteverde;


import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.pom.uMonteverde.BuscarElementosPage;
import tests.pom.uMonteverde.LoginPage;
import tests.pom.uMonteverde.Menu;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class BuscarElementosTest extends BaseTest {

    @BeforeClass
    public void setup() {

        LoginPage lgn = new LoginPage(driver);
        waitExplicitFiveSeconds();
        lgn.login("admin", "1234");
        Menu mn = new Menu(driver);
        waitExplicitFiveSeconds();
        mn.clickearBuscarElementos();
        waitExplicitFiveSeconds();
        bep = new BuscarElementosPage(driver);
    }


    private BuscarElementosPage bep;



    @Test()
    @TestName("Muestra Busqueda de elementos")
    public void tituloBienvenida(){
        assertTrue(bep.getBusquedaDeElementos());
    }


    @Test()
    @TestName("Verifica el Titulo bienvenida")
    public void verificaBuscarElementos(){
        assertEquals(bep.getTituloBusquedaDeElementos(),"Práctica: Búsqueda de Elementos");
    }

    @Test()
    @TestName("Muestra Label usuario")
    public void TestlabelUsuario(){
        assertTrue(bep.getLabelUsuario());
    }


    @Test()
    @TestName("Verifica Label usuario")
    public void verfificaLabelUsuario(){

    }

    @Test()
    @TestName("Buscar Input de name")
    public void InputName(){
        assertTrue(bep.getInputName());
    }



    @Test()
    @TestName("Muestra Label contraseña")
    public void TestlabelContrasenia(){
        assertTrue(bep.getLabelContrasenia());
    }

    @Test()
    @TestName("Verifica Label contraseña")
    public void VerificalabelContrasenia(){
        assertEquals(bep.getlabelContentContrasenia(),"Contraseña");
    }
    @Test()
    @TestName("Buscar Input de id")
    public void InputId(){
        assertTrue(bep.getInputId());
    }

    @Test()
    @TestName("Muestra Label Boton")
    public void labelBoton(){
        assertTrue(bep.getLabelBoton());
    }


    @Test()
    @TestName("Verifica Label Boton")
    public void verificalabelBoton(){
        assertEquals(bep.getLabelContentBoton(),"Botón con CLASS:");
    }
    @Test()
    @TestName("Buscar Boton de enviar")
    public void clickButtonId(){
        assertTrue(bep.getSendButton());
    }

    @Test()
    @TestName("Muestra Label de option")
    public void LabelOption(){
        assertTrue(bep.getLabelOption());
    }

    @Test()
    @TestName("Verifica Label de option")
    public void verificarLabelOption(){
        assertEquals(bep.getLabelContentOption(),"Opción seleccionada: Ninguna");
    }

    @Test()
    @TestName("Buscar label Date ")
    public void getLabelDate(){
        assertTrue(bep.getLabelDate());
    }


    @Test()
    @TestName("Buscar Date div")
    public void buscarDateDiv(){
        assertTrue(bep.getDateDiv());
    }

    @Test()
    @TestName("Buscar Date div")
    public void dateDiv(){
        assertTrue(bep.getFechaActual());
    }

    @Test()
    @TestName("Label CSS selector")
    public void labelCssSelector(){
        assertTrue(bep.getLabelCssSelector());
    }

    @Test()
    @TestName("Verifica Label CSS selector")
    public void verificaLabelCssSelector(){
        assertEquals(bep.getLabelContentCssSelector(),"Enlace con CSS Selector:");
    }

    @Test()
    @TestName("Buscar Otro sitio")
    public void irOtroSitio(){
        assertTrue(bep.getButtonOtroSitio());
    }


}
