package com.okta.demo.okta.controller;

import com.okta.demo.service.converter.ConverterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
//@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private ConverterService converterService;

    public static final String VERIFICATION_HEADER = "x-okta-verification-challenge";

    @GetMapping("/")
    public String anyGet(HttpServletRequest httpRequest) {
        //System.out.println("GET:" + httpRequest.getRequestURI());
        String verification_header_value = httpRequest.getHeader(VERIFICATION_HEADER);
        return "{\"verification\":" + "\"" + verification_header_value + "\"}";
    }

    @PostMapping("/groups")
    public String createGroup(@RequestBody String body) {
        System.out.println("/groups");
        log.info("Body: " + body);
        return converterService.createGroup(body);
    }
}
