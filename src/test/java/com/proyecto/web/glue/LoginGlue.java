package com.proyecto.web.glue;

import com.proyecto.web.step.HomeStep;
import com.proyecto.web.step.LoginStep;
import com.fw.Util;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginGlue {

    private WebDriver driver;
    private LoginStep loginStep;
    private HomeStep homeStep;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        driver = new ChromeDriver();
        loginStep = new LoginStep(driver);
        homeStep = new HomeStep(driver);
    }

    @After
    public void tearsDown() throws InterruptedException {
        Util.waitThread(2000);
        driver.quit();
    }

    @Dado("que estoy en la pantalla de inicio")
    public void queEstoyEnLaPantallaDeInicio(){
        driver.get("http://127.0.0.1:8000/login");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Cuando("ingreso las credenciales del usuario")
    public void ingresoLasCredencialesDelUsuario(DataTable credentialTable) {
        String username = Util.getValueFromDataTable(credentialTable, "user");
        String password = Util.getValueFromDataTable(credentialTable, "pass");
        loginStep.login(username, password);
    }

    @Entonces("se debería validar que estoy en el home de la plataforma")
    public void seDeberíaValidarQueEstoyEnElHomeDeLaPlataforma() {
        Assertions.assertEquals("Dashboard", homeStep.getTituloHome());
    }

    @Entonces("se debería validar que se muestra el mensaje de error {string}")
    public void seDeberíaValidarQueSeMuestraElMensajeDeError(String mensajeError) {
        Assertions.assertEquals(mensajeError, loginStep.getError());
    }
}
