package com.boha.weather_sandbox.controllers;

import com.boha.weather_sandbox.services.WeatherService;
import com.boha.weather_sandbox.util.E;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class KhayaController {
    private static final Logger LOGGER = Logger.getLogger(KhayaController.class.getSimpleName());

    private final WeatherService service;

    public KhayaController(WeatherService service) {
        this.service = service;
        LOGGER.info(E.BLUE_DOT + E.BLUE_DOT + " KhayaController constructed, WeatherService injected. ");

    }

    @GetMapping("/")
    private String  hi() {
        LOGGER.info(E.BLUE_HEART + "Base endpoint  requested  ..." + E.BLUE_HEART);
        return "WeatherSandboxApplication saying hi at " + new DateTime().toDateTimeISO();
    }
}
