package com.api.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class TestController {
    
    @GetMapping("/test")
    public String getTest() {
        return "<h1>Test</h1>";
    }
}

