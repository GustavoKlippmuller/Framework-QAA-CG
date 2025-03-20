package tests.uMonteverde;

import framework.annotations.TestName;
import framework.base.BaseTest;
import org.testng.annotations.*;
import tests.pom.uMonteverde.LlenarFormularioPage;
import tests.pom.uMonteverde.LoginPage;
import tests.pom.uMonteverde.Menu;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.testng.AssertJUnit.*;

public class LlenarFormularioTest extends BaseTest {
    @BeforeClass
    public void setup() {
        LoginPage lgp = new LoginPage(driver);
        lgp.login("admin","1234");
        Menu mmn = new Menu(driver);
        mmn.clickearLlenarFormulario();
        waitExplicitFiveSeconds();
        lfp = new LlenarFormularioPage(driver);
    }
    private LlenarFormularioPage lfp;

    @BeforeMethod()
    public void cleanInputs(){
        lfp.limpiarInputName();
        lfp.limpiarInputEmail();
        lfp.limpiarInputPassword();
        lfp.limpiarInputEdad();
        lfp.limpiarInputFecha();
    }


    @Test()
    @TestName("Se Muestra completar email")
    public void verificarQuePidaCompletarEmail() throws InterruptedException {
        lfp.enterInputName("Lionel");
        lfp.enterInputPassword("12345678vdasvas");
        lfp.inputEdad(18);
        lfp.inputFecha("14-03-2006");
        waitExplicitFiveSeconds();
        lfp.clickButon();
        Thread.sleep(10000);
        assertEquals(lfp.getMensajeEmailIncompleta(),"Completa este campo");
    }


    @Test()
    @TestName("Se Muestra completar contraseña")
    public void verificarQuePidaCompletarContraseña() throws InterruptedException {
        lfp.enterInputName("Lionel");
        lfp.enterInputEmal("lionel@gmail.com");
        lfp.inputEdad(18);
        lfp.inputFecha("14-03-2006");
        waitExplicitFiveSeconds();
        lfp.clickButon();
        Thread.sleep(10000);
        assertEquals(lfp.getMensajeContraseñaIncompleta(),"Completa este campo");
    }

    @Test()
    @TestName("Se Muestra completar edad")
    public void verificarQuePidaCompletarEdad() throws InterruptedException {
        lfp.enterInputName("Lionel");
        lfp.enterInputEmal("lionel@gmail.com");
        lfp.enterInputPassword("12345678vdasvas");
        lfp.inputFecha("14-03-2006");
        waitExplicitFiveSeconds();
        lfp.clickButon();
        Thread.sleep(10000);
        assertEquals(lfp.getMensajeEdadIncompleta(),"Completa este campo");
    }




    @Test()
    @TestName("Se Muestra completar fecha")
    public void verificarQuePidaCompletarFecha() throws InterruptedException {
        lfp.enterInputName("Lionel");
        lfp.enterInputEmal("lionel@gmail.com");
        lfp.enterInputPassword("12345678vdasvas");
        lfp.inputEdad(18);
        waitExplicitFiveSeconds();
        lfp.clickButon();
        Thread.sleep(10000);
        assertEquals(lfp.getMensajeFechaIncompleta(),"Completa este campo");
    }




    @Test()
    @TestName("Se ve el cartel de error password")
    public void verificarCaracteresPassword(){
        lfp.enterInputName("Lionel");
        lfp.enterInputEmal("lionel@gmail.com");
        lfp.enterInputPassword("123");
        lfp.inputEdad(18);
        lfp.inputFecha("14-03-2006");
        lfp.clickButon();
        assertTrue(lfp.getErrorPassword());
        assertEquals(lfp.getInputName(),"Lionel");
        assertEquals(lfp.getInputEmail(),"lionel@gmail.com");
        assertEquals(lfp.getInputPassword(),"123");
        assertEquals(lfp.getInputEdad(),18);
        assertEquals(lfp.getFecha(),"2006-03-14");

    }

    @Test()
    @TestName("Se ve el cartel de error edad")
    public void verificarDebeSerMayor(){
        lfp.enterInputName("Lionel");
        lfp.enterInputEmal("lionel@gmail.com");
        lfp.enterInputPassword("123456789");
        lfp.inputEdad(4);
        lfp.inputFecha("14-03-2021");
        lfp.clickButon();
        assertTrue(lfp.getErrorEdad());
        assertEquals(lfp.getInputName(),"Lionel");
        assertEquals(lfp.getInputEmail(),"lionel@gmail.com");
        assertEquals(lfp.getInputPassword(),"123456789");
        assertEquals(lfp.getInputEdad(),4);
        assertEquals(lfp.getFecha(),"2021-03-14");

    }

    @Test()
    @TestName("Se ve el cartel de error edad y contraseña")
    public void verificarDebeSerMayorYVerificarContraseña(){
        lfp.enterInputName("Lionel");
        lfp.enterInputEmal("lionel@gmail.com");
        lfp.enterInputPassword("123");
        lfp.inputEdad(3);
        lfp.inputFecha("14-03-2021");
        lfp.clickButon();
        assertTrue(lfp.getErrorEdad());
        assertTrue(lfp.getErrorPassword());
        assertEquals(lfp.getInputName(),"Lionel");
        assertEquals(lfp.getInputEmail(),"lionel@gmail.com");
        assertEquals(lfp.getInputPassword(),"123");
        assertEquals(lfp.getInputEdad(),3);
        assertEquals(lfp.getFecha(),"2021-03-14");

    }




    @Test()
    @TestName("Se ve el envio de datos")
    public void verificarSubidaDeDatos(){
        lfp.enterInputName("Lionel");
        lfp.enterInputEmal("lionel@gmail.com");
        lfp.enterInputPassword("12345678vdasvas");
        lfp.inputEdad(18);
        lfp.inputFecha("14-03-2006");
        lfp.clickButon();
        assertEquals(lfp.getInputName(),"Lionel");
        assertEquals(lfp.getInputEmail(),"lionel@gmail.com");
        assertEquals(lfp.getInputPassword(),"12345678vdasvas");
        assertEquals(lfp.getInputEdad(),18);
        assertEquals(lfp.getFecha(),"2006-03-14");
    }


}
