package com.prc.Weather_App.controller;

import com.prc.Weather_App.dto.Root;
import com.prc.Weather_App.dto.WeatherResponse;
import com.prc.Weather_App.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class Controller {
    @Autowired
    private WeatherService service;

    @GetMapping("/{city}")
    public String getWeatherData(@PathVariable String city){
        return service.test();
    }
    @GetMapping("/my/{city}")
    public WeatherResponse WeatherData(@PathVariable String city){
        return service.getData(city);
    }

}
