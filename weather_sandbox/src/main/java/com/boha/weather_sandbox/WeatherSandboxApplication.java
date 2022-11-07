package com.boha.weather_sandbox;

import com.boha.weather_sandbox.models.DailyPacked;
import com.boha.weather_sandbox.models.HourlyPacked;
import com.boha.weather_sandbox.models.WeatherData;
import com.boha.weather_sandbox.services.WeatherService;
import com.boha.weather_sandbox.util.E;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class WeatherSandboxApplication implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger LOGGER = Logger.getLogger(WeatherSandboxApplication.class.getSimpleName());

    public static void main(String[] args) {

        LOGGER.info(E.AMP + "WeatherSandboxApplication started " + E.AMP + E.AMP+ E.AMP);
        SpringApplication.run(WeatherSandboxApplication.class, args);
        LOGGER.info(E.YELLOW_STAR + E.YELLOW_STAR + "WeatherSandboxApplication completed startup " + E.AMP + E.AMP+ E.AMP);
    }

    @Autowired
    private WeatherService weatherService;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        LOGGER.info(E.AMP+E.AMP+" onApplicationEvent ..." + E.AMP);
        try {
            WeatherData wd = weatherService.getForecasts(-25.76,27.85, "CET");
            LOGGER.info(E.AMP+E.AMP+" Weather Data for location: "  + wd.getLatitude()
                    + " longitude: " + wd.getLongitude() + E.AMP);

            List<HourlyPacked>  list = wd.getHourly().getHourlyPacked();
            LOGGER.info(E.AMP+E.AMP+" Weather Data: " + list.size() + " hourly  records");

            List<DailyPacked>  m = wd.getDaily().getDailyPacked();
            LOGGER.info(E.AMP+E.AMP+" Weather Data: " + m.size() + " daily records");
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
