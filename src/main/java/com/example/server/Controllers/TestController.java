package com.example.server.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public Mono<String> test() {
        // Generate a string greater than 2KB (~2048 characters)
        byte[] largeData = new byte[2000]; // 3KB data
        Arrays.fill(largeData, (byte) 'A'); // Fill with 'A'
        // logs
        logger.info("{}: Call to /api/test successful", new Date(System.currentTimeMillis()).toLocalDate());
        return Mono.just(new String(largeData, StandardCharsets.UTF_8));
    }
}

