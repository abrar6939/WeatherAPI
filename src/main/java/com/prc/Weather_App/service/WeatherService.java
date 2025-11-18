package com.prc.Weather_App.service;

import com.prc.Weather_App.dto.Root;
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

   public Root getData(String city){
        String url = apiurl+"?key="+apikey+"&q="+city;
       try {
           Root response = template.getForObject(url, Root.class);
           return response;
       } catch (RestClientException ex) {
           // Wrap the error so the controller returns a meaningful HTTP status and message
           throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Failed to call weather API: " + ex.getMessage(), ex);
       }
   }
}
