package com.proyecto.web.step;

import com.proyecto.web.page.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeStep {
    private WebDriver driver;

    public HomeStep(WebDriver driver) {
        this.driver = driver;
    }

    private HomePage homePage() {
        return new HomePage(this.driver);
    }

    public String getTituloHome(){
        return homePage().getTituloHome();
    }
}
