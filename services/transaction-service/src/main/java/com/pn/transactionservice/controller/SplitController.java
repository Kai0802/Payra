package com.pn.transactionservice.controller;

import com.pn.transactionservice.dto.requestdto.SplitRequestDTO;
import com.pn.transactionservice.dto.responsedto.SplitResponseDTO;
import com.pn.transactionservice.service.SplitCalculationService;
import com.pn.transactionservice.service.SplitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/splits")
public class SplitController {

    private final SplitService splitService;
    private final SplitCalculationService splitCalculationService;
    public SplitController(SplitService splitService, SplitCalculationService splitCalculationService) {
        this.splitService = splitService;
        this.splitCalculationService = splitCalculationService;
    }

    @PostMapping
    public ResponseEntity<SplitResponseDTO> createSplit(@RequestBody SplitRequestDTO splitRequestDTO) {
        SplitResponseDTO response = splitService.createSplit(splitRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
