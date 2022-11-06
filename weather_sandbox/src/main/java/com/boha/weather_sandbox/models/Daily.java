package com.boha.weather_sandbox.models;

import com.boha.weather_sandbox.util.E;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Daily {
    private static final Logger LOGGER = Logger.getLogger(Daily.class.getSimpleName());
    static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    ArrayList<String> time = new ArrayList<>();
    ArrayList<Integer> weathercode = new ArrayList<>();
    ArrayList<Double> temperature_2m_max = new ArrayList<>();
    ArrayList<Double> temperature_2m_min = new ArrayList<>();
    ArrayList<Double> apparent_temperature_max = new ArrayList<>();
    ArrayList<Double> apparent_temperature_min = new ArrayList<>();
    ArrayList<String> sunrise = new ArrayList<>();
    ArrayList<String> sunset = new ArrayList<>();
    ArrayList<Double> precipitation_sum = new ArrayList<>();
    ArrayList<Double> rain_sum = new ArrayList<>();
    ArrayList<Double> showers_sum = new ArrayList<>();
    ArrayList<Double> snowfall_sum = new ArrayList<>();
    ArrayList<Double> precipitation_hours = new ArrayList<>();
    ArrayList<Double> windspeed_10m_max = new ArrayList<>();
    ArrayList<Double> windgusts_10m_max = new ArrayList<>();
    ArrayList<Double> winddirection_10m_dominant = new ArrayList<Double>();
    ArrayList<Double> shortwave_radiation_sum = new ArrayList<>();
    ArrayList<Double> et0_fao_evapotranspiration = new ArrayList<>();


    public ArrayList<String> getTime() {
        return time;
    }

    public void setTime(ArrayList<String> time) {
        this.time = time;
    }

    public ArrayList<Integer> getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(ArrayList<Integer> weathercode) {
        this.weathercode = weathercode;
    }

    public ArrayList<Double> getTemperature_2m_max() {
        return temperature_2m_max;
    }

    public void setTemperature_2m_max(ArrayList<Double> temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }

    public ArrayList<Double> getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public void setTemperature_2m_min(ArrayList<Double> temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }

    public ArrayList<Double> getApparent_temperature_max() {
        return apparent_temperature_max;
    }

    public void setApparent_temperature_max(ArrayList<Double> apparent_temperature_max) {
        this.apparent_temperature_max = apparent_temperature_max;
    }

    public ArrayList<Double> getApparent_temperature_min() {
        return apparent_temperature_min;
    }

    public void setApparent_temperature_min(ArrayList<Double> apparent_temperature_min) {
        this.apparent_temperature_min = apparent_temperature_min;
    }

    public ArrayList<String> getSunrise() {
        return sunrise;
    }

    public void setSunrise(ArrayList<String> sunrise) {
        this.sunrise = sunrise;
    }

    public ArrayList<String> getSunset() {
        return sunset;
    }

    public void setSunset(ArrayList<String> sunset) {
        this.sunset = sunset;
    }

    public ArrayList<Double> getPrecipitation_sum() {
        return precipitation_sum;
    }

    public void setPrecipitation_sum(ArrayList<Double> precipitation_sum) {
        this.precipitation_sum = precipitation_sum;
    }

    public ArrayList<Double> getRain_sum() {
        return rain_sum;
    }

    public void setRain_sum(ArrayList<Double> rain_sum) {
        this.rain_sum = rain_sum;
    }

    public ArrayList<Double> getShowers_sum() {
        return showers_sum;
    }

    public void setShowers_sum(ArrayList<Double> showers_sum) {
        this.showers_sum = showers_sum;
    }

    public ArrayList<Double> getSnowfall_sum() {
        return snowfall_sum;
    }

    public void setSnowfall_sum(ArrayList<Double> snowfall_sum) {
        this.snowfall_sum = snowfall_sum;
    }

    public ArrayList<Double> getPrecipitation_hours() {
        return precipitation_hours;
    }

    public void setPrecipitation_hours(ArrayList<Double> precipitation_hours) {
        this.precipitation_hours = precipitation_hours;
    }

    public ArrayList<Double> getWindspeed_10m_max() {
        return windspeed_10m_max;
    }

    public void setWindspeed_10m_max(ArrayList<Double> windspeed_10m_max) {
        this.windspeed_10m_max = windspeed_10m_max;
    }

    public ArrayList<Double> getWindgusts_10m_max() {
        return windgusts_10m_max;
    }

    public void setWindgusts_10m_max(ArrayList<Double> windgusts_10m_max) {
        this.windgusts_10m_max = windgusts_10m_max;
    }

    public ArrayList<Double> getWinddirection_10m_dominant() {
        return winddirection_10m_dominant;
    }

    public void setWinddirection_10m_dominant(ArrayList<Double> winddirection_10m_dominant) {
        this.winddirection_10m_dominant = winddirection_10m_dominant;
    }

    public ArrayList<Double> getShortwave_radiation_sum() {
        return shortwave_radiation_sum;
    }

    public void setShortwave_radiation_sum(ArrayList<Double> shortwave_radiation_sum) {
        this.shortwave_radiation_sum = shortwave_radiation_sum;
    }

    public ArrayList<Double> getEt0_fao_evapotranspiration() {
        return et0_fao_evapotranspiration;
    }

    public void setEt0_fao_evapotranspiration(ArrayList<Double> et0_fao_evapotranspiration) {
        this.et0_fao_evapotranspiration = et0_fao_evapotranspiration;
    }

    public List<DailyPacked> getDailyPacked() {
        List<DailyPacked> list = new ArrayList<>();
        for (String s : time) {
            DailyPacked m = new DailyPacked();
            m.setTime(s);
            list.add(m);
        }
        int index = 0;
        for (Integer wc : weathercode) {
            DailyPacked m = list.get(index);
            m.setWeatherCode(wc);
            index++;
        }
        index = 0;
        for (Double wc : temperature_2m_max) {
            DailyPacked m = list.get(index);
            m.setMaxTemperature(wc);
            index++;
        }
        index = 0;
        for (Double wc : temperature_2m_min) {
            DailyPacked m = list.get(index);
            m.setMinTemperature(wc);
            index++;
        }
        index = 0;
        for (String wc : sunrise) {
            DailyPacked m = list.get(index);
            m.setSunrise(wc);
            index++;
        }
        index = 0;
        for (String wc : sunset) {
            DailyPacked m = list.get(index);
            m.setSunset(wc);
            index++;
        }
        index = 0;
        for (Double wc : precipitation_sum) {
            DailyPacked m = list.get(index);
            m.setPrecipitationSum(wc);
            index++;
        }
        index = 0;
        for (Double wc : precipitation_hours) {
            DailyPacked m = list.get(index);
            m.setPrecipitationHours(wc);
            index++;
        }
        index = 0;
        for (Double wc : windspeed_10m_max) {
            DailyPacked m = list.get(index);
            m.setWindSpeedMax(wc);
            index++;
        }
        index = 0;
        for (Double wc : rain_sum) {
            DailyPacked m = list.get(index);
            m.setRainSum(wc);
            index++;
        }
        index = 0;
        for (Double wc : showers_sum) {
            DailyPacked m = list.get(index);
            m.setShowersSum(wc);
            index++;
        }
        index = 0;
        for (Double wc : winddirection_10m_dominant) {
            DailyPacked m = list.get(index);
            m.setWindDirectionDominant(wc);
            index++;
        }
        index = 0;
        for (Double wc : apparent_temperature_max) {
            DailyPacked m = list.get(index);
            m.setApparentMaxTemp(wc);
            index++;
        }
        index = 0;
        for (Double wc : apparent_temperature_min) {
            DailyPacked m = list.get(index);
            m.setApparentMinTemp(wc);
            index++;
        }
        index = 0;
        for (Double wc : shortwave_radiation_sum) {
            DailyPacked m = list.get(index);
            m.setShortwaveRadiation(wc);
            index++;
        }
        index = 0;
        for (Double wc : et0_fao_evapotranspiration) {
            DailyPacked m = list.get(index);
            m.setEvapoTranspiration(wc);
            index++;
        }

        int count = 0;
        for (DailyPacked dp : list) {
            LOGGER.info(E.RED_APPLE+E.RED_APPLE+
                    E.RED_APPLE+" DailyPacked: #" + (count+1) + " " + GSON.toJson(dp) + E.RED_APPLE);
            count++;
        }

        return list;
    }
}
