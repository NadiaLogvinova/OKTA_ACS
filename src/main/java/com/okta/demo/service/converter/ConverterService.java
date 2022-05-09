package com.okta.demo.service.converter;

import com.okta.demo.acs.service.AcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    @Autowired
    private AcsService acsService;

    public String createGroup(String string) {
        return acsService.postGroup(string);
    }
}
