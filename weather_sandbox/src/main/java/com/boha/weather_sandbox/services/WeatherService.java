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
    String prefix = "https://api.open-meteo.com/v1/forecast?";

    String buildLink(double lat, double lng) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append("latitude=").append(lat);
        sb.append("&longitude=").append(lng);
        sb.append("&hourly=temperature_2m,relativehumidity_2m,rain,showers,pressure_msl,surface_pressure,cloudcover,cloudcover_low,cloudcover_mid,cloudcover_high,windspeed_10m,windspeed_80m,windspeed_120m,windspeed_180m,winddirection_80m,temperature_80m,temperature_120m,temperature_180m");
        sb.append("&daily=weathercode,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,sunrise,sunset,precipitation_sum,rain_sum,showers_sum,snowfall_sum,precipitation_hours,windspeed_10m_max,windgusts_10m_max,winddirection_10m_dominant,shortwave_radiation_sum,et0_fao_evapotranspiration");
        sb.append("&timezone=GMT");
        return sb.toString();
    }
    OkHttpClient client = new OkHttpClient();

    public WeatherData getForecasts(double latitude, double longitude) throws Exception{
        LOGGER.info(E.YELLOW_STAR+E.YELLOW_STAR+ " getForecasts, lat:" + latitude + " lng: " + longitude);
        String link = buildLink(latitude,longitude);
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
            LOGGER.info("Response: " + mResp);
            return weatherData;
        } else {
            LOGGER.info(E.RED_DOT + " Error: code: " + response.code() + " - " + response.message());
            throw new Exception("Response code : " + response.code());
        }

    }
}
