package com.example.demo.controller;

import com.example.demo.service.SWAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sw")
public class SwController {

    @Autowired
    SWAPIService swapiService;


    @GetMapping("/people")
    public ResponseEntity getPeople() {
        System.out.println("getPeople");
        String response = swapiService.callRestService();
        System.out.println("deu resposta:" + response);
        return ResponseEntity.ok(response);
    }



}
