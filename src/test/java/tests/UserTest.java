package tests;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class UserTest extends BaseTest {

    @Override
    protected String getDescription() {
        return "Este test es el primero del framework";
    }

    @Test
    @TestName("Validar el nombre del usuario")
    public void testNameOfUser() {
        getNode().info("Se completó el formulario");
        assertTrue(true);
    }
}
