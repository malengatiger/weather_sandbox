package com.boha.weather_sandbox.controllers;

import com.boha.weather_sandbox.models.WeatherData;
import com.boha.weather_sandbox.services.WeatherService;
import com.boha.weather_sandbox.util.E;
import org.joda.time.DateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class KhayaController {
    private static final Logger LOGGER = Logger.getLogger(KhayaController.class.getSimpleName());

    private final WeatherService weatherService;

    public KhayaController(WeatherService weatherService) {
        this.weatherService = weatherService;
        LOGGER.info(E.BLUE_DOT + E.BLUE_DOT + " KhayaController constructed, WeatherService injected. ");

    }

    @GetMapping("/")
    private String  hi() {
        LOGGER.info(E.BLUE_HEART + "Base endpoint  requested  ..." + E.BLUE_HEART);
        return "WeatherSandboxApplication saying hi at " + new DateTime().toDateTimeISO();
    }
    @GetMapping("/getForecasts")
    private ResponseEntity<Object> getForecasts(@RequestParam double latitude, @RequestParam double longitude) {
        LOGGER.info(E.BLUE_HEART + "Forecast requested  ..." + E.BLUE_HEART);
        try {
            WeatherData wd =  weatherService.getForecasts(latitude,longitude);
            LOGGER.info(E.BLUE_HEART + "Forecast returned  ..." + wd.getLatitude()
                    + " longitude: " + wd.getLongitude() + " " + E.BLUE_HEART);
            return ResponseEntity.ok(wd);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
