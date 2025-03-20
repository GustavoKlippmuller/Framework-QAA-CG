package tests.gklippmuller;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.pom.LoginPage;
import tests.pom.gklippmuller.MainMenu;

import static org.testng.Assert.assertTrue;

public class MenuTest extends BaseTest {

    private MainMenu mainMenu;

    @BeforeClass
    public void setUp() {
        new LoginPage(driver).login();
        mainMenu = new MainMenu(driver);
    }

    @Test
    @TestName("La opción Elementos esta presente")
    public void testElementosIsPresent() {
        assertTrue(mainMenu.elementosIsPresent());
    }

    @Test
    @TestName("La opción 'Buscar Elementos' esta presente")
    public void testBuscarElementosIsPresent() {
        assertTrue(mainMenu.buscarElementosIsPresent());
    }
}
