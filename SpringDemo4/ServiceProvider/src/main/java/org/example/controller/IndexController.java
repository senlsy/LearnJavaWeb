package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String appName;

    @GetMapping(value = "/service/{id}")
    public String getService(@PathVariable("id") Integer id) {

        String str = "<h2>Nacos - Service Provider</h2>";
        str += "<p>Service Name: " + appName + "<br>";
        str += "Port: " + serverPort + "<br>";
        str += "Id: " + id + "</p>";

        return str;
    }
}