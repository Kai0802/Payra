package com.pn.transactionservice.service;

import com.pn.transactionservice.dto.requestdto.ItemAllocationRequestDTO;
import com.pn.transactionservice.dto.requestdto.ParticipantRequestDTO;
import com.pn.transactionservice.dto.requestdto.SplitRequestDTO;
import com.pn.transactionservice.dto.responsedto.SplitResponseDTO;
import com.pn.transactionservice.model.Split;
import com.pn.transactionservice.model.enummodel.SplitMethod;
import com.pn.transactionservice.repository.ItemAllocationRepository;
import com.pn.transactionservice.repository.SplitParticipantRepository;
import com.pn.transactionservice.repository.SplitRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class SplitService {
    private final SplitRepository splitRepository;
    private final SplitParticipantRepository splitParticipantRepository;
    private final ItemAllocationRepository itemAllocationRepository;
    private final SplitCalculationService splitCalculationService;
    public SplitService(SplitRepository splitRepository,
                        SplitParticipantRepository splitParticipantRepository,
                        ItemAllocationRepository itemAllocationRepository,
                        SplitCalculationService splitCalculationService) {
        this.splitRepository = splitRepository;
        this.splitParticipantRepository = splitParticipantRepository;
        this.itemAllocationRepository = itemAllocationRepository;
        this.splitCalculationService = splitCalculationService;

    }

    public SplitResponseDTO createSplit(SplitRequestDTO splitRequestDTO) {
        /* TODO: creating the logic for mapping the split request dto to the DB model and call the calculation logic
            in here
         * */
        // mapper has already been created
        // how do we do the calculation here?
        // put everything in a requestContext and put everything in a responseContext when done calculated
        // what do we need in the requestContext
        BigDecimal totalAmount = splitRequestDTO.getReceiptData().getTotalAmount();
        BigDecimal subtotal = splitRequestDTO.getReceiptData().getSubtotal();
        BigDecimal taxRate = splitRequestDTO.getReceiptData().getTaxRate();
        BigDecimal tax = splitRequestDTO.getReceiptData().getTaxAmount();
        BigDecimal tip = splitRequestDTO.getReceiptData().getTipAmount();
        SplitMethod splitMethod = splitRequestDTO.getSplitMethod();
        Split split = Split.builder()
                .receiptId(splitRequestDTO.getReceiptId())
                .payerId(splitRequestDTO.getPayerId())
                .totalAmount(totalAmount)
                .subtotal(subtotal)
                .taxRate(taxRate)
                .taxAmount(tax)
                .tipAmount(tip)
                .splitMethod(splitMethod)
                .description(splitRequestDTO.getDescription())
                .build();

        List<ParticipantRequestDTO> participants = splitRequestDTO.getParticipants();

        SplitResponseDTO splitResponseDTO = splitCalculationService.calculate(totalAmount, subtotal, taxRate, tax, tip, splitMethod, participants);

        // calling save to the DB as the last step since we need to do the calculation before saving it to the db
        return new SplitResponseDTO();
    }
}
