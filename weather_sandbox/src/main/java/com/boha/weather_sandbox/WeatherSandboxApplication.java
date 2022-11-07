package com.boha.weather_sandbox;

import com.boha.weather_sandbox.models.DailyPacked;
import com.boha.weather_sandbox.models.HourlyPacked;
import com.boha.weather_sandbox.models.WeatherData;
import com.boha.weather_sandbox.services.WeatherService;
import com.boha.weather_sandbox.util.E;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class WeatherSandboxApplication implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger LOGGER = Logger.getLogger(WeatherSandboxApplication.class.getSimpleName());
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {

        LOGGER.info(E.AMP + "WeatherSandboxApplication started " + E.AMP + E.AMP+ E.AMP);
        SpringApplication.run(WeatherSandboxApplication.class, args);
        LOGGER.info(E.YELLOW_STAR + E.YELLOW_STAR + "WeatherSandboxApplication completed startup " + E.AMP + E.AMP+ E.AMP);
    }

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private Environment environment;

    @Value("${spring.profiles.active}")
    private String profile;



    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        LOGGER.info(E.AMP+E.AMP+" onApplicationEvent ..." + E.AMP+" imeTaken: " + event.getTimeTaken().toString());
        try {
            WeatherData wd = weatherService.getForecasts(-25.76,27.85, "CET");
            LOGGER.info(E.AMP+E.AMP+" Weather Data for location: "  + wd.getLatitude()
                    + " longitude: " + wd.getLongitude() + E.AMP);

            List<DailyPacked>  m = wd.getDaily().getDailyPacked();
            List<HourlyPacked>  list = wd.getHourly().getHourlyPacked();

            LOGGER.info(E.AMP+E.AMP+" Weather Data: " + m.size() + " daily records");
            LOGGER.info(E.AMP+E.AMP+E.AMP+E.AMP+
                    " Active Profile: " + profile);
            if (profile.equalsIgnoreCase("dev")
                    || profile.equalsIgnoreCase("default")) {
                int count = 0;
                for (DailyPacked dp : m) {
                    LOGGER.info(E.RED_APPLE + E.RED_APPLE +
                            E.RED_APPLE + " DailyPacked: #" + (count + 1) + " " + GSON.toJson(dp) + E.RED_APPLE);
                    count++;
                }
                for (HourlyPacked dp : list) {
                    LOGGER.info(E.AMP + E.AMP +
                            E.AMP + " DailyPacked: #" + (count + 1) + " " + GSON.toJson(dp) + E.RED_APPLE);
                    count++;
                }
            } else  {
                LOGGER.info(E.AMP+E.AMP+" We are in prod now, no stupid logs ");
            }

            LOGGER.info(E.AMP+E.AMP+" Weather Data: " + list.size() + " hourly  records");

        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
