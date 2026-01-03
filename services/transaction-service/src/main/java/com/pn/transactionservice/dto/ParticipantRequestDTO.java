package com.pn.transactionservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ParticipantRequestDTO {
    private String userId;
    private String firstName;
    private Boolean isPayer;
    private List<ItemAllocationRequestDTO> itemAllocations;

}
