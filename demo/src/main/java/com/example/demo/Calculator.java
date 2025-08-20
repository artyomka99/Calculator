package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class Calculator {

        @GetMapping("/calc")
        public String calculate(
                @RequestParam double a,
                @RequestParam double b,
                @RequestParam String op
        )
}
