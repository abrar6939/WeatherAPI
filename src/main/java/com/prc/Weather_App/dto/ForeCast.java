package com.prc.Weather_App.dto;

import java.util.List;

public class ForeCast {
    public List<ForeCastDay> forecastday;
    
    // Getter
    public List<ForeCastDay> getForecastday() {
        return forecastday;
    }
    
    // Setter
    public void setForecastday(List<ForeCastDay> forecastday) {
        this.forecastday = forecastday;
    }
}
