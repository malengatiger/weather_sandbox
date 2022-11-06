package com.boha.weather_sandbox.models;


import com.boha.weather_sandbox.services.WeatherService;
import com.boha.weather_sandbox.util.E;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class WeatherData {
    private static final Logger LOGGER = Logger.getLogger(WeatherData.class.getSimpleName());
    static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private float latitude;
    private float longitude;
    private float generationtime_ms;
    private float utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private float elevation;
    Hourly_units hourly_units;
    Hourly hourly;
    Daily_units daily_units;
    Daily daily;

    public Hourly_units getHourly_units() {
        return hourly_units;
    }

    public void setHourly_units(Hourly_units hourly_units) {
        this.hourly_units = hourly_units;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public Daily_units getDaily_units() {
        return daily_units;
    }

    public void setDaily_units(Daily_units daily_units) {
        this.daily_units = daily_units;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

// Getter Methods

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getGenerationtime_ms() {
        return generationtime_ms;
    }

    public float getUtc_offset_seconds() {
        return utc_offset_seconds;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getTimezone_abbreviation() {
        return timezone_abbreviation;
    }

    public float getElevation() {
        return elevation;
    }


    // Setter Methods

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setGenerationtime_ms(float generationtime_ms) {
        this.generationtime_ms = generationtime_ms;
    }

    public void setUtc_offset_seconds(float utc_offset_seconds) {
        this.utc_offset_seconds = utc_offset_seconds;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setTimezone_abbreviation(String timezone_abbreviation) {
        this.timezone_abbreviation = timezone_abbreviation;
    }

    public void setElevation(float elevation) {
        this.elevation = elevation;
    }


    public List<HourlyPacked> getHourlyPacked() {
        List<HourlyPacked> list = new ArrayList<>();
        for (Double o : getHourly().getTemperature_2m()) {
             HourlyPacked hp = new HourlyPacked();
             hp.setTemperature(o);
             list.add(hp);

        }
        int index = 0;
        for (Double o : getHourly().getRain()) {
            HourlyPacked hp = list.get(index);
            hp.setRain(o);
            index++;
        }
        index = 0;
        for (Double o : getHourly().getShowers()) {
            HourlyPacked hp = list.get(index);
            hp.setShowers(o);
            index++;
        }
        index = 0;
        for (String o : getHourly().getTime()) {
            HourlyPacked hp = list.get(index);
            hp.setTime(o);
            index++;
        }
        index = 0;
        for (Integer o : getHourly().getCloudcover()) {
            HourlyPacked hp = list.get(index);
            hp.setCloudCover(o);
            index++;
        }
        index = 0;
        for (Double o : getHourly().getWindspeed_10m()) {
            HourlyPacked hp = list.get(index);
            hp.setWindSpeed(o);
            index++;
        }
        index = 0;
        for (Integer o : getHourly().getRelativehumidity_2m()) {
            HourlyPacked hp = list.get(index);
            hp.setRelativeHumidity(o);
            index++;
        }
        index = 0;
        for (Double o : getHourly().getPressure_msl()) {
            HourlyPacked hp = list.get(index);
            hp.setPressure(o);
            index++;
        }
        int count = 0;
        for (HourlyPacked packed : list) {
            LOGGER.info(E.AMP + E.AMP + E.AMP + E.AMP +
                    " HourlyPacked: " + GSON.toJson(packed));
            LOGGER.info(E.AMP+E.AMP+
                    E.AMP+" HourlyPacked: #" + (count+1) + " "
                    + GSON.toJson(packed) + E.AMP);
            count++;

        }

        return list;
    }
}
