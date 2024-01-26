package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service.url}")
    private String serverURL; //服务提供者的服务名

    @GetMapping("/consumer/service/{id}")
    public String getConsumerService(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serverURL + "/service/" + id, String.class);
    }
}