package com.proyecto.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement userInput;

    @FindBy(id = "password")
    private WebElement passInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@role='alert']/strong")
    private WebElement mensajeError;

    public void ingresarUsuario(String user){
        userInput.sendKeys(user);
    }

    public void ingresarContraseña(String contraseña){
        passInput.sendKeys(contraseña);
    }

    public void loginButton(){
        loginButton.click();
    }

    public String mensajeError(){
        return mensajeError.getText();
    }
}
