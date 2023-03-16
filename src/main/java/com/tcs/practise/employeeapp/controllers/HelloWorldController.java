package com.tcs.practise.employeeapp.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController
 */
@RestController
public class HelloWorldController {

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @GetMapping("/hello-world")
    public String hellloWorld() {
        return "Hello World";
    }

    @RequestMapping(value = "/hello-get", method = RequestMethod.GET)
    public String helloWorldReq() {
        return "Hello world via request mapping!";
    }

    @GetMapping("/hello/{name}")
    public String helloPathvariable(@PathVariable String name) {
        return "Hello " + name;
    }
    
    @GetMapping("hello/int")
    public String i18nString(@RequestHeader(name = "Accept-language", required = false) String locale) {
        return messageSource.getMessage("label.hello", null, new Locale(locale));
    }
}