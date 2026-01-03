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
public class PayeeResponseDTO {
    private String payeeId; // refer to the user id in user service
    private String payeeName;
    private BigDecimal totalPaid; // refer to the total amount that the payee paid for the bill
    private BigDecimal payeeAmount; // refer to the payee portion of the bill
}
