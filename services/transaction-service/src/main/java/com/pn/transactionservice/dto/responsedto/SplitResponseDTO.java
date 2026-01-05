package com.pn.transactionservice.dto.responsedto;

import com.pn.transactionservice.model.enummodel.SplitMethod;
import com.pn.transactionservice.model.enummodel.SplitStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SplitResponseDTO {
    private String splitId;
    private String receiptId;
    private String payerId;

    //financial detail
    private BigDecimal totalAmount;
    private BigDecimal subtotal;
    private BigDecimal taxRate;
    private BigDecimal taxAmount;
    private BigDecimal tipAmount;

    private SplitMethod splitMethod;
    private SplitStatus splitStatus;
    private String description;

    private List<ParticipantResponseDTO> participants;

    // meta data
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime finalizedAt;
}
