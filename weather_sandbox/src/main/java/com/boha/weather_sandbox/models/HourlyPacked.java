package com.boha.weather_sandbox.models;

public class HourlyPacked {
    public HourlyPacked() {
    }

    public HourlyPacked(String time, double temperature, int relativeHumidity,
                        double rain, double showers, double pressure, double surfacePressure,
                        int cloudCover, double windSpeed) {
        this.time = time;
        this.temperature = temperature;
        this.relativeHumidity = relativeHumidity;
        this.rain = rain;
        this.showers = showers;
        this.pressure = pressure;
        this.surfacePressure = surfacePressure;
        this.cloudCover = cloudCover;
        this.windSpeed = windSpeed;
    }

    String time;
    double temperature;
    int relativeHumidity;
    double rain;
    double showers;
    double pressure, surfacePressure;
    int cloudCover;
    double windSpeed;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(int relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public double getShowers() {
        return showers;
    }

    public void setShowers(double showers) {
        this.showers = showers;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getSurfacePressure() {
        return surfacePressure;
    }

    public void setSurfacePressure(double surfacePressure) {
        this.surfacePressure = surfacePressure;
    }

    public int getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(int cloudCover) {
        this.cloudCover = cloudCover;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
