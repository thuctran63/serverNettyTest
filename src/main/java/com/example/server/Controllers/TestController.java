package com.example.server.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public Mono<String> test() {
        // Generate a string greater than 2KB (~2048 characters)
        byte[] largeData = new byte[2000]; // 3KB data
        Arrays.fill(largeData, (byte) 'A'); // Fill with 'A'

        return Mono.just(new String(largeData, StandardCharsets.UTF_8));
    }
}

