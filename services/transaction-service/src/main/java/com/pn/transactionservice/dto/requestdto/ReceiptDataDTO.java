package com.pn.transactionservice.dto.requestdto;

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
public class ReceiptDataDTO {
    private BigDecimal totalAmount;
    private BigDecimal subtotal;
    private BigDecimal taxAmount;
    private BigDecimal taxRate;
    private BigDecimal tipAmount;
    private List<ReceiptItemDTO> items;

}
