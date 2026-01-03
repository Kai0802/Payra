package com.pn.transactionservice.dto.requestdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReceiptItemDTO {
    private String receiptItemId;
    private String receiptItemName;
    private BigDecimal receiptItemPrice;
    private BigDecimal receiptItemQuantity;
    private Boolean isTaxable;
}
