package com.proyecto.web.step;

import com.proyecto.web.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginStep {
    private WebDriver driver;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
    }

    private LoginPage loginPage() {
        return new LoginPage(this.driver);
    }

    public void login(String user,String pass){
        loginPage().ingresarUsuario(user);
        if (pass == null) pass= "";
        loginPage().ingresarContraseña(pass);

        loginPage().loginButton();
    }

    public String getError(){
        return loginPage().mensajeError();
    }
}
