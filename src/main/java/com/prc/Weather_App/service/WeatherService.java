package com.prc.Weather_App.service;

import com.prc.Weather_App.dto.Root;
import com.prc.Weather_App.dto.WeatherResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apikey;
    // this value is used as we are setting the api detalis
    @Value("${weather.api.url}")
    private String apiurl;

    // this is used for calling from any outer api
    private RestTemplate template = new RestTemplate();


    public String test(){
        return "ALL Good";
    }

   public WeatherResponse getData(String city){
        String url = apiurl+"?key="+apikey+"&q="+city;
        Root response = template.getForObject(url, Root.class);
        WeatherResponse weatherResponse = new WeatherResponse();

        weatherResponse.setCity(response.getLocation().name);
        weatherResponse.setRegion(response.getLocation().region);
        weatherResponse.setCountry(response.getLocation().country);

        String condition = response.getCurrent().getCondition().getText();
        weatherResponse.setCondition(condition);
        weatherResponse.setTemperature(response.getCurrent().getTemp_c());
        return weatherResponse;


       }
   }

