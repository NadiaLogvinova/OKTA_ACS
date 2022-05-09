package com.okta.demo.acs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AcsService {

    private String acsUrl = "http://localhost:8080";

    @Autowired
    private RestTemplate restTemplate;

    public String postGroup(String body) {
        return restTemplate.postForObject(acsUrl + "/acsGroups", body, String.class);
    }
}
