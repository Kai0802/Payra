package com.pn.transactionservice.dto.requestdto;

import com.pn.transactionservice.model.enummodel.SplitMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

// this class represents the split that user wants to do after scanning the receipt
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SplitRequestDTO {
    private String receiptId;
    private String payerId; // refer to the person who scanned the receipt and entirely paid for it
    private LocalDateTime receiptDate;
    private SplitMethod splitMethod;
    private String description;
    private ReceiptDataDTO receiptData;
    private List<ParticipantRequestDTO> participants;
}
