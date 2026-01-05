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
public class ItemAllocationRequestDTO {
    private String ReceiptItemId;
    private String receiptItemName;
    private BigDecimal splitPortion; // whether to pay for half or third and fourth
    private String notes;
}
