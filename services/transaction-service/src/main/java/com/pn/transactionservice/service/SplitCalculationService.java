package com.pn.transactionservice.service;

import com.pn.transactionservice.dto.requestdto.ItemAllocationRequestDTO;
import com.pn.transactionservice.dto.requestdto.ParticipantRequestDTO;
import com.pn.transactionservice.dto.responsedto.ItemAllocationResponseDTO;
import com.pn.transactionservice.dto.responsedto.ParticipantResponseDTO;
import com.pn.transactionservice.dto.responsedto.SplitResponseDTO;
import com.pn.transactionservice.model.Split;
import com.pn.transactionservice.model.SplitParticipant;
import com.pn.transactionservice.model.enummodel.SplitMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@Slf4j
public class SplitCalculationService {



    public BigDecimal calculateTipShare(SplitParticipant splitParticipant, Split split) {
        return split.getTipAmount().multiply(splitParticipant.getTipShare());
    }


    public SplitResponseDTO calculate(BigDecimal totalAmount, BigDecimal subtotal, BigDecimal taxRate, BigDecimal tax, BigDecimal tip, SplitMethod splitMethod, List<ParticipantRequestDTO> participants) {
        // creating the splitResponseDTO out here
        SplitResponseDTO response = new SplitResponseDTO();
        if (SplitMethod.EQUAL.equals(splitMethod)) {
            BigDecimal splitPortion = BigDecimal.ONE.divide(new BigDecimal(participants.size()), 4, RoundingMode.HALF_UP);
            // need to build item allocation in each of the participant first
            for (ParticipantRequestDTO participant : participants) {
                ParticipantResponseDTO participantResponseDTO = ParticipantResponseDTO.builder()
                        .userId(participant.getUserId())
                        .isPayer(participant.getIsPayer())
                        .build();
                // all item would be the same split portion
                ItemAllocationResponseDTO itemAllocationResponseDTO = ItemAllocationResponseDTO.builder()
                        .splitPortion(splitPortion)
                        .build();
                for (ItemAllocationRequestDTO itemAllocation : participant.getItemAllocations()) {
                    // we will continue building the participant response dto in here
                    // will actually calculate the financial detail in here
                    // since this is equal split method -> all item allocation will be the same

                }
                response.getParticipants().add(participantResponseDTO);
            }
        }
        return null;
    }
}
