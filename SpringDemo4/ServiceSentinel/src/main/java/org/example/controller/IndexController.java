package org.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.slots.block.BlockException;

@RestController
public class IndexController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String appName;

    @GetMapping(value = "/service/{id}")
    public String getService(@PathVariable("id") Integer id) {

        String str = "<h2>Nacos - Service Sentinel</h2>";
        str += "<p>Service Name: " + appName + "<br>";
        str += "Port: " + serverPort + "<br>";
        str += "Id: " + id + "</p>";

        return str;
    }

    @GetMapping(value = "/service/sphu")
    public String sphu() {
        return sphuRes();
    }

    public String sphuRes() {

        String str = "<h2>Service Sentinel - SphU Resource</h2>";
        str += "<p>Service Name: " + appName + "<br>";
        str += "Port: " + serverPort + "</p>";
        Entry entry = null;

        try {

            entry = SphU.entry("sphuRes");
            str += "<p>Status: success</p>";

        } catch (BlockException e) {
            str += "<p>Status: service restricted</p>";
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }

        return str;
    }

    @GetMapping(value = "/service/spho")
    public String spho() {
        return sphoRes();
    }

    public String sphoRes() {

        String str = "<h2>Service Sentinel - SphO Resource</h2>";
        str += "<p>Service Name: " + appName + "<br>";
        str += "Port: " + serverPort + "</p>";

        if (SphO.entry("sphoRes")) {
            try {
                str += "<p>Status: success</p>";
            } finally {
                SphO.exit();
            }
        } else {
            str += "<p>Status: service restricted</p>";
        }

        return str;
    }

    @GetMapping(value = "/service/anno")
    @SentinelResource(value = "annoRes")
    public String annoRes() {
        String str = "<h2>Service Sentinel - Annotation Resource</h2>";
        str += "<p>Service Name: " + appName + "<br>";
        str += "Port: " + serverPort + "</p>";

        return str;
    }

}