package tests;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.Test;
import tests.pom.AcercaPage;
import tests.pom.PrincipalPage;

import static org.testng.Assert.assertEquals;

public class AcercaDeTest extends BaseTest {

    @Override
    protected String getDescription() {
        return "Este test abarca la página Acerca de";
    }

    @Test
    @TestName("Verificar titulo pagina acerda de")
    public void testTituloAcercaDe() {
        new PrincipalPage(driver).clickOnAcercaDe();
        AcercaPage acerca = new AcercaPage(driver);
        assertEquals("Acerca de", acerca.getTitle(), "Los titulos no coincide");
    }
}
