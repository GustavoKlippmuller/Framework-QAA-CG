package tests;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.pom.PrincipalPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BasePageTest extends BaseTest {

    private PrincipalPage principal;

    @Override
    protected String getDescription() {
        return "Este test abarca la página principal";
    }

    @BeforeClass
    public void setPageObjects() {
        principal = new PrincipalPage(driver);
    }

    @Test
    @TestName("Verificar titulo de la página")
    public void testTitle() {
        assertEquals("Basic Page", principal.getTitle());
    }


    @Test
    @TestName("Completar Input Username")
    public void testInputUsername() {
        principal.fillInputUsername("gklippmuller");
        assertEquals("gklippmuller", principal.getInputUsernameText(),"El texto en el input no fue completado correctamente");
    }

    @Test
    @TestName("Seleccionar un curso")
    public void testSelectCurso() {
        principal.selectCurso("Java");
        assertEquals("Java", principal.getSelectedCurso(), "El curso seleccionado no corresponde al elegido");
    }

    @Test
    @TestName("Seleccionar un color")
    public void testSelectColor() {
        principal.chooseColor("verde");
        assertEquals("verde", principal.getSelectedColor(), "El color seleccionado no coincide");
    }

    @Test
    @TestName("Aceptar terminos y condiciones")
    public void testTerminosYCondiciones() {
        principal.checkTermConditions();
        assertTrue(principal.getStatusTyC());
    }

    @Test
    @TestName("Completar fechas")
    public void testFechas() {
        principal.fillDate("22-12-1978");
        principal.fillDatetime("2025-03-10T14:30");
    }

}
