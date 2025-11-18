package com.prc.Weather_App.dto;

public class WeatherResponse {
    private String city;
    private String condition ;
    private double temperature;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public WeatherResponse(String city, String condition, double temperature) {
        this.city = city;
        this.condition = condition;
        this.temperature = temperature;
    }
}
