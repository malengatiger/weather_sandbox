package com.boha.weather_sandbox.models;

public class DailyPacked {
    public DailyPacked() {
    }

    String time;
    int weatherCode;
    double minTemperature, maxTemperature;
    double apparentMinTemp, apparentMaxTemp;
    String sunrise, sunset;
    double precipitationSum, rainSum, showersSum;
    double precipitationHours, windSpeedMax;
    Double windDirectionDominant;
    double shortwaveRadiation, evapoTranspiration;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getApparentMinTemp() {
        return apparentMinTemp;
    }

    public void setApparentMinTemp(double apparentMinTemp) {
        this.apparentMinTemp = apparentMinTemp;
    }

    public double getApparentMaxTemp() {
        return apparentMaxTemp;
    }

    public void setApparentMaxTemp(double apparentMaxTemp) {
        this.apparentMaxTemp = apparentMaxTemp;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public double getPrecipitationSum() {
        return precipitationSum;
    }

    public void setPrecipitationSum(double precipitationSum) {
        this.precipitationSum = precipitationSum;
    }

    public double getRainSum() {
        return rainSum;
    }

    public void setRainSum(double rainSum) {
        this.rainSum = rainSum;
    }

    public double getShowersSum() {
        return showersSum;
    }

    public void setShowersSum(double showersSum) {
        this.showersSum = showersSum;
    }

    public double getPrecipitationHours() {
        return precipitationHours;
    }

    public void setPrecipitationHours(double precipitationHours) {
        this.precipitationHours = precipitationHours;
    }

    public double getWindSpeedMax() {
        return windSpeedMax;
    }

    public void setWindSpeedMax(double windSpeedMax) {
        this.windSpeedMax = windSpeedMax;
    }

    public Double getWindDirectionDominant() {
        return windDirectionDominant;
    }

    public void setWindDirectionDominant(Double windDirectionDominant) {
        this.windDirectionDominant = windDirectionDominant;
    }

    public double getShortwaveRadiation() {
        return shortwaveRadiation;
    }

    public void setShortwaveRadiation(double shortwaveRadiation) {
        this.shortwaveRadiation = shortwaveRadiation;
    }

    public double getEvapoTranspiration() {
        return evapoTranspiration;
    }

    public void setEvapoTranspiration(double evapoTranspiration) {
        this.evapoTranspiration = evapoTranspiration;
    }
}
