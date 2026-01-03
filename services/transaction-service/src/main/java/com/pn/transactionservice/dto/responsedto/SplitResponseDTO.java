package com.pn.transactionservice.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SplitResponseDTO {
    private PayeeResponseDTO payeeResponseDTO;
    private List<PayerResponseDTO> payerResponseDTO;
}
