package com.pn.transactionservice.dto.responsedto;

import com.pn.transactionservice.model.enummodel.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ParticipantResponseDTO {
    private String participantId;
    private String userId;
    private String username;
    private Boolean isPayer;

    // financial detail
//    private BigDecimal itemSubtotal; // do we need this?
    private BigDecimal taxShare;
    private BigDecimal tipShare;
    private BigDecimal totalOwed;

    private PaymentStatus paymentStatus;

    private List<ItemAllocationResponseDTO> itemAllocations;


}
