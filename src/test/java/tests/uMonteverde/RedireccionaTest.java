package tests.uMonteverde;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class RedireccionaTest extends BaseTest {



    String urlLogin = "https://www.kapa8technologies.com/login.html";
    @BeforeTest
    public void setup() {
        driver.get("https://www.kapa8technologies.com/dashboard.html");
    }


    @Test()
    @TestName("Verifica que redirija al login")
    public void verificaLogin(){
        String urlActual = driver.getCurrentUrl();
        assertEquals(urlActual,urlLogin);
    }
}
