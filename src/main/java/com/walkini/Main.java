package com.walkini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
