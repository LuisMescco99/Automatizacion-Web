package com.proyecto.web.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        features = "src/test/resources/features",
        glue = "com.proyecto.web.glue",
        stepNotifications = true,
        tags = "@LOGIN_EXITOSO"

        //Probando
)
public class RunnerTest {
}
