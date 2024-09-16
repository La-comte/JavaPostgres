package com.example.Laba6.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class WorkController {
    @GetMapping("getStatus")
    public ResponseEntity<String> work(){
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
