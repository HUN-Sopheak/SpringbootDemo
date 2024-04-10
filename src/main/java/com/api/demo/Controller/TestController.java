package com.api.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/test")
    public String getTest() {
        return "<h1>Hello Spring boot</h1>";
    }

    @GetMapping("/test/test2")
    public String getTest2() {
        return "<h1>Hello Spring boot 2</h1>";
    }
}

