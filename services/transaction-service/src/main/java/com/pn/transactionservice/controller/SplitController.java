package com.pn.transactionservice.controller;

import com.pn.transactionservice.service.SplitCalculationService;
import com.pn.transactionservice.service.SplitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/splits")
public class SplitController {

    private final SplitService splitService;
    private final SplitCalculationService splitCalculationService;
    public SplitController(SplitService splitService, SplitCalculationService splitCalculationService) {
        this.splitService = splitService;
        this.splitCalculationService = splitCalculationService;
    }

    @GetMapping
    public String Hello() {
        return "Hello World!";
    }
}
