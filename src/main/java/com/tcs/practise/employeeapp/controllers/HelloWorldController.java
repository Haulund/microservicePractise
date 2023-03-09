package com.tcs.practise.employeeapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController
 */
@RestController
public class HelloWorldController {

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
    
}