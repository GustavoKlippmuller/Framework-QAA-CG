package tests;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.Test;
import tests.pom.uMonteverde.LoginPage;
import tests.pom.MainPage;
import tests.pom.TablesPage;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class IFrameTest extends BaseTest {

    @Override
    protected String getDescription() {
        return "Este test verifica el funcionamiento del IFrame";
    }

    @Test
    @TestName("Verificar que pueda validar un elemento dentro de un IFrame")
    public void testIFrame() {
        new LoginPage(driver).login("user","1234");
        new MainPage(driver).selectFormsTable();

        TablesPage tables = new TablesPage(driver);

        assertEquals(4, tables.getAmountColumns());

        List<String> headers = Arrays.asList("Nombre", "Apellido", "Edad", "Ciudad");
        assertEquals(headers, tables.getHeaders());

        List<String> rowOne = Arrays.asList("Juan", "Pérez", "25", "Buenos Aires");
        assertEquals(rowOne, tables.getRows().get(0));
    }
}
