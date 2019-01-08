package com.example.demo.controller;

import com.example.demo.service.SWAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sw")
public class SwController {

    @Autowired
    SWAPIService swapiService;

    @RequestMapping("/people")
    public void getPeople(){
        System.out.println("Call Rest Service");
        swapiService.callRestService();
    }

}
