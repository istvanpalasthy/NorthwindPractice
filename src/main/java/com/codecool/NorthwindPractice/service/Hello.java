package com.codecool.NorthwindPractice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Hello {
    @GetMapping("/")
    public String home(){

        return "Hello World";
    }
}
