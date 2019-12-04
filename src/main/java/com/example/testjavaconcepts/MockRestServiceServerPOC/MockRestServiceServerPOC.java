package com.example.testjavaconcepts.MockRestServiceServerPOC;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class MockRestServiceServerPOC {

    @Autowired
    RestTemplate restTemplate;

    public String callWS(){
        String url = "https://httpbin.org/get";
        String result = null;
        try{
            result = restTemplate.getForObject(url, String.class);
        }catch(HttpClientErrorException e){
            result = e.getMessage();
        }
        return result;
    }

}
