package com.pn.transactionservice.mapper;


import com.pn.transactionservice.dto.responsedto.ItemAllocationResponseDTO;
import com.pn.transactionservice.dto.responsedto.ParticipantResponseDTO;
import com.pn.transactionservice.dto.responsedto.SplitResponseDTO;
import com.pn.transactionservice.model.ItemAllocation;
import com.pn.transactionservice.model.Split;
import com.pn.transactionservice.model.SplitParticipant;
import org.mapstruct.Mapper;

@Mapper
public interface SplitMapper {
    SplitResponseDTO toSplitResponseDTO(Split split);
    ParticipantResponseDTO toParticipantResponseDTO(SplitParticipant splitParticipant);
    ItemAllocationResponseDTO toItemAllocationResponseDTO(ItemAllocation itemAllocation);
}
