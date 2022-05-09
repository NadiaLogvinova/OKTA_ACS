package com.okta.demo.acs.service;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AcsConfiguration {

    @Bean
    @Profile("local")
    public WireMockServer getWireMockServer() {
        WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.start();

        stubFor(post(urlPathMatching("/acsGroups")).willReturn(aResponse().withBody("Test string")));
        return wireMockServer;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
