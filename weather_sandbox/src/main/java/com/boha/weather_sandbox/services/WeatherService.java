package com.boha.weather_sandbox.services;

import com.boha.weather_sandbox.WeatherSandboxApplication;
import com.boha.weather_sandbox.util.E;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class WeatherService {
    private static final Logger LOGGER = Logger.getLogger(WeatherService.class.getSimpleName());

    public WeatherService() {
        LOGGER.info(E.ORANGE_HEART + E.ORANGE_HEART + " WeatherService constructed. ");
    }
}
