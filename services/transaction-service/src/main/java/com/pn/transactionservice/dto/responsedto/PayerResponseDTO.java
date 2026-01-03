package com.pn.transactionservice.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PayerResponseDTO {
    private String payerId;
    private String payerName;
    private BigDecimal amountOwe;
}
