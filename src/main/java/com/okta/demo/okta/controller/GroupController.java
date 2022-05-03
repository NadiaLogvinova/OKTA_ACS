package com.okta.demo.okta.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
//@RequestMapping("/groups")
public class GroupController {

    public static final String VERIFICATION_HEADER = "x-okta-verification-challenge";

    @GetMapping("/*")
    public String anyGet(HttpServletRequest httpRequest) {
        System.out.println("GET:" + httpRequest.getRequestURI());
        String verification_header_value = httpRequest.getHeader(VERIFICATION_HEADER);
        return "{\"verification\":" + "\"" + verification_header_value + "\"}";
    }

    @PostMapping("/*")
    public String anyPost(HttpServletRequest httpRequest) {
        System.out.println("POST:" + httpRequest.getRequestURI());
        return "200";
    }

    @PostMapping("/groups")
    public String createGroup() {
        System.out.println("/groups");
        return "200";
    }
}
