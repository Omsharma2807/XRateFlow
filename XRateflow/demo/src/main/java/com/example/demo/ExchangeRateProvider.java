package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service

public class ExchangeRateProvider {
    private final RestTemplate restTemplate;
    public Map<String,Double> fetchRates(String base){
        String url= "https://api.exchangerate.host/latest?base=" + base;
        Map<String,Object> response= restTemplate.getForObject(url,Map.class);
        if(response != null && response.containsKey("rates")){
            return (Map<String,Double>) response.get("rates");

        }
        else{
            throw new RuntimeException("Failed to fetch Rates at this moment");
        }
    }
}
