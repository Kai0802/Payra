package com.pn.transactionservice.service;

import com.pn.transactionservice.dto.requestdto.SplitRequestDTO;
import com.pn.transactionservice.dto.responsedto.SplitResponseDTO;
import com.pn.transactionservice.repository.ItemAllocationRepository;
import com.pn.transactionservice.repository.SplitParticipantRepository;
import com.pn.transactionservice.repository.SplitRepository;
import org.springframework.stereotype.Service;

@Service
public class SplitService {
    private final SplitRepository splitRepository;
    private final SplitParticipantRepository splitParticipantRepository;
    private final ItemAllocationRepository itemAllocationRepository;

    public SplitService(SplitRepository splitRepository,
                        SplitParticipantRepository splitParticipantRepository,
                        ItemAllocationRepository itemAllocationRepository) {
        this.splitRepository = splitRepository;
        this.splitParticipantRepository = splitParticipantRepository;
        this.itemAllocationRepository = itemAllocationRepository;
    }

    public SplitResponseDTO createSplit(SplitRequestDTO splitRequestDTO) {
        return new SplitResponseDTO();
    }
}
