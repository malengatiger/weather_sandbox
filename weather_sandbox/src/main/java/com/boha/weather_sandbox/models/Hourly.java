package com.boha.weather_sandbox.models;

import com.boha.weather_sandbox.util.E;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Hourly {
    private static final Logger LOGGER = Logger.getLogger(WeatherData.class.getSimpleName());
    static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @Autowired
    private Environment environment;
    ArrayList<String> time = new ArrayList<>();
    ArrayList<Double> temperature_2m = new ArrayList<>();
    ArrayList<Integer> relativehumidity_2m = new ArrayList<>();
    ArrayList<Double> rain = new ArrayList<>();
    ArrayList<Double> showers = new ArrayList<>();
    ArrayList<Double> pressure_msl = new ArrayList<>();
    ArrayList<Double> surface_pressure = new ArrayList<>();
    ArrayList<Integer> cloudcover = new ArrayList<>();
    ArrayList<Integer> cloudcover_low = new ArrayList<>();
    ArrayList<Integer> cloudcover_mid = new ArrayList<>();
    ArrayList<Integer> cloudcover_high = new ArrayList<>();
    ArrayList<Double> windspeed_10m = new ArrayList<>();
    ArrayList<Double> windspeed_80m = new ArrayList<>();
    ArrayList<Double> windspeed_120m = new ArrayList<>();
    ArrayList<Double> windspeed_180m = new ArrayList<>();
    ArrayList<Integer> winddirection_80m = new ArrayList<>();
    ArrayList<Double> temperature_80m = new ArrayList<>();
    ArrayList<Double> temperature_120m = new ArrayList<>();
    ArrayList<Double> temperature_180m = new ArrayList<>();


    public ArrayList<String> getTime() {
        return time;
    }

    public void setTime(ArrayList<String> time) {
        this.time = time;
    }

    public ArrayList<Double> getTemperature_2m() {
        return temperature_2m;
    }

    public void setTemperature_2m(ArrayList<Double> temperature_2m) {
        this.temperature_2m = temperature_2m;
    }

    public ArrayList<Integer> getRelativehumidity_2m() {
        return relativehumidity_2m;
    }

    public void setRelativehumidity_2m(ArrayList<Integer> relativehumidity_2m) {
        this.relativehumidity_2m = relativehumidity_2m;
    }

    public ArrayList<Double> getRain() {
        return rain;
    }

    public void setRain(ArrayList<Double> rain) {
        this.rain = rain;
    }

    public ArrayList<Double> getShowers() {
        return showers;
    }

    public void setShowers(ArrayList<Double> showers) {
        this.showers = showers;
    }

    public ArrayList<Double> getPressure_msl() {
        return pressure_msl;
    }

    public void setPressure_msl(ArrayList<Double> pressure_msl) {
        this.pressure_msl = pressure_msl;
    }

    public ArrayList<Double> getSurface_pressure() {
        return surface_pressure;
    }

    public void setSurface_pressure(ArrayList<Double> surface_pressure) {
        this.surface_pressure = surface_pressure;
    }

    public ArrayList<Integer> getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(ArrayList<Integer> cloudcover) {
        this.cloudcover = cloudcover;
    }

    public ArrayList<Integer> getCloudcover_low() {
        return cloudcover_low;
    }

    public void setCloudcover_low(ArrayList<Integer> cloudcover_low) {
        this.cloudcover_low = cloudcover_low;
    }

    public ArrayList<Integer> getCloudcover_mid() {
        return cloudcover_mid;
    }

    public void setCloudcover_mid(ArrayList<Integer> cloudcover_mid) {
        this.cloudcover_mid = cloudcover_mid;
    }

    public ArrayList<Integer> getCloudcover_high() {
        return cloudcover_high;
    }

    public void setCloudcover_high(ArrayList<Integer> cloudcover_high) {
        this.cloudcover_high = cloudcover_high;
    }

    public ArrayList<Double> getWindspeed_10m() {
        return windspeed_10m;
    }

    public void setWindspeed_10m(ArrayList<Double> windspeed_10m) {
        this.windspeed_10m = windspeed_10m;
    }

    public ArrayList<Double> getWindspeed_80m() {
        return windspeed_80m;
    }

    public void setWindspeed_80m(ArrayList<Double> windspeed_80m) {
        this.windspeed_80m = windspeed_80m;
    }

    public ArrayList<Double> getWindspeed_120m() {
        return windspeed_120m;
    }

    public void setWindspeed_120m(ArrayList<Double> windspeed_120m) {
        this.windspeed_120m = windspeed_120m;
    }

    public ArrayList<Double> getWindspeed_180m() {
        return windspeed_180m;
    }

    public void setWindspeed_180m(ArrayList<Double> windspeed_180m) {
        this.windspeed_180m = windspeed_180m;
    }

    public ArrayList<Integer> getWinddirection_80m() {
        return winddirection_80m;
    }

    public void setWinddirection_80m(ArrayList<Integer> winddirection_80m) {
        this.winddirection_80m = winddirection_80m;
    }

    public ArrayList<Double> getTemperature_80m() {
        return temperature_80m;
    }

    public void setTemperature_80m(ArrayList<Double> temperature_80m) {
        this.temperature_80m = temperature_80m;
    }

    public ArrayList<Double> getTemperature_120m() {
        return temperature_120m;
    }

    public void setTemperature_120m(ArrayList<Double> temperature_120m) {
        this.temperature_120m = temperature_120m;
    }

    public ArrayList<Double> getTemperature_180m() {
        return temperature_180m;
    }

    public void setTemperature_180m(ArrayList<Double> temperature_180m) {
        this.temperature_180m = temperature_180m;
    }

    public List<HourlyPacked> getHourlyPacked() {
        List<HourlyPacked> list = new ArrayList<>();
        for (Double o : getTemperature_2m()) {
            HourlyPacked hp = new HourlyPacked();
            hp.setTemperature(o);
            list.add(hp);

        }
        int index = 0;
        for (Double o : getRain()) {
            HourlyPacked hp = list.get(index);
            hp.setRain(o);
            index++;
        }
        index = 0;
        for (Double o : getShowers()) {
            HourlyPacked hp = list.get(index);
            hp.setShowers(o);
            index++;
        }
        index = 0;
        for (String o : getTime()) {
            HourlyPacked hp = list.get(index);
            hp.setTime(o);
            index++;
        }
        index = 0;
        for (Integer o : getCloudcover()) {
            HourlyPacked hp = list.get(index);
            hp.setCloudCover(o);
            index++;
        }
        index = 0;
        for (Double o : getWindspeed_10m()) {
            HourlyPacked hp = list.get(index);
            hp.setWindSpeed(o);
            index++;
        }
        index = 0;
        for (Integer o : getRelativehumidity_2m()) {
            HourlyPacked hp = list.get(index);
            hp.setRelativeHumidity(o);
            index++;
        }
        index = 0;
        for (Double o : getPressure_msl()) {
            HourlyPacked hp = list.get(index);
            hp.setPressure(o);
            index++;
        }

        return list;

    }
}
