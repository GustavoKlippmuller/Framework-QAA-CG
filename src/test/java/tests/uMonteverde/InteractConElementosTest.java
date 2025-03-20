package tests.uMonteverde;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.InteractTest;
import tests.pom.uMonteverde.InteractuarConElementosPage;
import tests.pom.uMonteverde.LoginPage;
import tests.pom.uMonteverde.Menu;

import static org.testng.AssertJUnit.*;

public class InteractConElementosTest extends BaseTest {

    @BeforeClass
    public void setup() {
        LoginPage lgp = new LoginPage(driver);
        lgp.login("admin","1234");
        Menu mmn = new Menu(driver);
        mmn.clickearInteractuarConElementos();
        ice = new InteractuarConElementosPage(driver);
    }

    private InteractuarConElementosPage ice;


    @Test()
    @TestName("llena el campo name")
    public void llenaElFirstName(){
        ice.interactFirstName("Lionel");
        assertEquals(ice.getFirstName(),"Lionel");

    }

    @Test()
    @TestName("llena el campo apellido")
    public void llenaElLastName(){
        ice.interactSecondName("Messi");
        assertEquals(ice.getSecondName(),"Messi");
    }



    @Test()
    @TestName("Elige en el dropdown el dni")
    public void seleccionaEnElDropdownDni(){
        ice.selectOptions(1);
        assertEquals(ice.getSelectOptions(),"dni");
    }


    @Test()
    @TestName("Elige en el dropdown el le")
    public void seleccionaEnElDropdownLe(){
        ice.selectOptions(2);
        assertEquals(ice.getSelectOptions(),"le");
    }


    @Test()
    @TestName("Elige en el dropdown el lc")
    public void seleccionaEnElDropdownLC(){
        ice.selectOptions(3);
        assertEquals(ice.getSelectOptions(),"lc");
    }


    @Test()
    @TestName("Elige en el dropdown el ci")
    public void seleccionaEnElDropdownCi(){
        ice.selectOptions(4);
        assertEquals(ice.getSelectOptions(),"ci");
    }

    @Test()
    @TestName("Elige en el dropdown el pas")
    public void seleccionaEnElDropdownPas(){
        ice.selectOptions(5);
        assertEquals(ice.getSelectOptions(),"pas");
    }

    @Test()
    @TestName("Elige en el checkBox el Admin")
    public void seleccionaEnElCheckBoxAdministrador() {
        ice.clickAdmin();
        assertFalse(ice.stateManager());
        assertFalse(ice.stateColaborator());
        assertFalse(ice.stateGuest());
        assertFalse(ice.stateReader());
        assertTrue(ice.stateAdmin());
        ice.clickAdmin();
    }

    @Test()
    @TestName("Elige en el checkBox el gestor de proyectos")
    public void seleccionaEnElCheckBoxManager() {
        ice.clickManager();
        assertFalse(ice.stateAdmin());
        assertFalse(ice.stateColaborator());
        assertFalse(ice.stateGuest());
        assertFalse(ice.stateReader());
        assertTrue(ice.stateManager());
        ice.clickManager();
    }

    @Test()
    @TestName("Elige en el checkBox el Colaborador")
    public void seleccionaEnElCheckBoxColaboratir() {
        ice.clickColaborator();
        assertFalse(ice.stateManager());
        assertFalse(ice.stateAdmin());
        assertFalse(ice.stateGuest());
        assertFalse(ice.stateReader());
        assertTrue(ice.stateColaborator());
        ice.clickColaborator();
    }

    @Test()
    @TestName("Elige en el checkBox el Reader")
    public void seleccionaEnElCheckBoxReader() {
        ice.clickReader();
        assertFalse(ice.stateManager());
        assertFalse(ice.stateColaborator());
        assertFalse(ice.stateGuest());
        assertFalse(ice.stateAdmin());
        assertTrue(ice.stateReader());
        ice.clickReader();
    }

    @Test()
    @TestName("Elige en el checkBox el Invitado")
    public void seleccionaEnElCheckBoxGuest() {
        ice.clickGuest();
        assertFalse(ice.stateManager());
        assertFalse(ice.stateColaborator());
        assertFalse(ice.stateAdmin());
        assertFalse(ice.stateReader());
        assertTrue(ice.stateGuest());
        ice.clickGuest();
    }

    @Test()
    @TestName("Elige el radio virtual")
    public void seleccionaVirtualRadio(){
        ice.clickRadioVirtual();
        assertFalse(ice.getStateRadiHibrido());
        assertFalse(ice.getStateRadioPresencial());
        assertTrue(ice.getStateRadioVirtual());
    }

    @Test()
    @TestName("Elige el radio hibrido")
    public void seleccionaHibridoRadio(){
        ice.clickRadioHibrido();
        assertFalse(ice.getStateRadioVirtual());
        assertFalse(ice.getStateRadioPresencial());
        assertTrue(ice.getStateRadiHibrido());
    }

    @Test()
    @TestName("Elige el radio presencial")
    public void seleccionaPresencialRadio(){
        ice.clickRadioPresencial();
        assertFalse(ice.getStateRadioVirtual());
        assertFalse(ice.getStateRadiHibrido());
        assertTrue(ice.getStateRadioPresencial());
    }
}
