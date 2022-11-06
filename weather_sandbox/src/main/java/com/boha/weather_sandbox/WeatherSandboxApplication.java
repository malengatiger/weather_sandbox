package com.boha.weather_sandbox;

import com.boha.weather_sandbox.util.E;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.util.logging.Logger;

@SpringBootApplication
public class WeatherSandboxApplication implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger LOGGER = Logger.getLogger(WeatherSandboxApplication.class.getSimpleName());

    public static void main(String[] args) {

        LOGGER.info(E.AMP + "WeatherSandboxApplication started " + E.AMP + E.AMP+ E.AMP);
        SpringApplication.run(WeatherSandboxApplication.class, args);
        LOGGER.info(E.YELLOW_STAR + E.YELLOW_STAR + "WeatherSandboxApplication completed startup " + E.AMP + E.AMP+ E.AMP);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        LOGGER.info(E.AMP+E.AMP+" onApplicationEvent ..." + E.AMP);
    }
}
