package com.boha.weather_sandbox.services;

import com.boha.weather_sandbox.WeatherSandboxApplication;
import com.boha.weather_sandbox.models.WeatherData;
import com.boha.weather_sandbox.util.E;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.*;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class WeatherService {
    private static final Logger LOGGER = Logger.getLogger(WeatherService.class.getSimpleName());
    static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public WeatherService() {
        LOGGER.info(E.ORANGE_HEART + E.ORANGE_HEART + " WeatherService constructed. ");
    }

    //https://api.open-meteo.com/v1/forecast?latitude=-25.76&longitude=27.85&hourly=temperature_2m,relativehumidity_2m,rain,showers,pressure_msl,surface_pressure,cloudcover,cloudcover_low,cloudcover_mid,cloudcover_high,windspeed_10m,windspeed_80m,windspeed_120m,windspeed_180m,winddirection_80m,temperature_80m,temperature_120m,temperature_180m&daily=weathercode,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,sunrise,sunset,precipitation_sum,rain_sum,showers_sum,snowfall_sum,precipitation_hours,windspeed_10m_max,windgusts_10m_max,winddirection_10m_dominant,shortwave_radiation_sum,et0_fao_evapotranspiration
    private static final String prefix = "https://api.open-meteo.com/v1/forecast?";
    private static final String hourly = "temperature_2m,relativehumidity_2m,rain,showers,pressure_msl,surface_pressure,cloudcover,cloudcover_low,cloudcover_mid,cloudcover_high,windspeed_10m,windspeed_80m,windspeed_120m,windspeed_180m,winddirection_80m,temperature_80m,temperature_120m,temperature_180m";
    private static final String daily = "weathercode,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,sunrise,sunset,precipitation_sum,rain_sum,showers_sum,snowfall_sum,precipitation_hours,windspeed_10m_max,windgusts_10m_max,winddirection_10m_dominant,shortwave_radiation_sum,et0_fao_evapotranspiration";
    private static final String defaultTimeZone = "GMT";
    private String buildLink(double latitude, double longitude, String timeZone) throws Exception {
        StringBuilder sb = new StringBuilder();
        if (timeZone == null)  {
            timeZone = defaultTimeZone;
        }
        sb.append(prefix);
        sb.append("latitude=").append(latitude);
        sb.append("&longitude=").append(longitude);
        sb.append("&hourly=").append(hourly);
        sb.append("&daily=").append(daily);
        sb.append("&timezone=").append(timeZone);
        return sb.toString();
    }
    OkHttpClient client = new OkHttpClient();

    public WeatherData getForecasts(double latitude, double longitude, String  timeZone) throws Exception{
        LOGGER.info(E.YELLOW_STAR+E.YELLOW_STAR+ " getForecasts, lat:" + latitude + " lng: " + longitude);
        String link = buildLink(latitude,longitude, timeZone);
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(link).newBuilder();

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.code() == 200) {
            String mResp = response.body().string();
            WeatherData weatherData = GSON.fromJson(mResp, WeatherData.class);
            LOGGER.info(E.RED_APPLE+E.RED_APPLE+E.RED_APPLE
                    +" Forecast Response: " + mResp
                    + " " + E.RED_APPLE);
            return weatherData;
        } else {
            LOGGER.info(E.RED_DOT + E.RED_DOT + E.RED_DOT +
                    " Forecast Error: code: " + response.code() + " - " + response.message());
            throw new Exception("Forecast Response code : " + response.code());
        }

    }
}
