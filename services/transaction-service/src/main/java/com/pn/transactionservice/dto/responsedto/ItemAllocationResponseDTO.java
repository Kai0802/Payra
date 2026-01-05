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
public class ItemAllocationResponseDTO {
    private String itemAllocationId;
    private String receiptItemId; // pulling this from the OCR service -> the item id that is printed on the receipt.
    private String itemName;
    private BigDecimal itemPrice;
    private Boolean isTaxable;
    private BigDecimal splitPortion;

    // calculated amounts -> this needs to be calculated before turning from ItemAllocationDTO to ItemAlloation model
    private BigDecimal allocatedAmount;
    private BigDecimal allocatedTax;
    
    private String notes;

}
