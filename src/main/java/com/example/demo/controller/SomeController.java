package com.example.demo.controller;

import com.example.demo.model.MyResult;
import com.example.demo.service.SomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SomeController {

    private final SomeService someService;

    public SomeController (SomeService someService) {
        this.someService = someService;
    }

    @GetMapping("/result")
    public List<MyResult> getMyResult() {
        return someService.getMyResult();
    }

}
