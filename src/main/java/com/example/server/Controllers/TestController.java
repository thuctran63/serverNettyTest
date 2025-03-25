package com.example.server.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class TestController {
    
    @GetMapping("/test")
    public Mono<String> test() {
        return Mono.just("Hello World");
    }
    
}
