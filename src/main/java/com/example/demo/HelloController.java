package com.example.demo;

import org.casbin.jcasbin.main.Enforcer;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URISyntaxException;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() throws URISyntaxException {
        Enforcer enforcer = new Enforcer("src/main/resources/data/security/model.conf", "src/main/resources/data/security/policy.csv");
        String sub = "alice";
        String obj = "data1";
        String act = "read";

        return "Greetings from Spring Boot! " + Boolean.toString(enforcer.enforce(sub, obj, act));
    }
}