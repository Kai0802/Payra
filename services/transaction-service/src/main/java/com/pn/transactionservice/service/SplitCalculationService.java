package com.pn.transactionservice.service;

import com.pn.transactionservice.model.Split;
import com.pn.transactionservice.model.SplitParticipant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class SplitCalculationService {



    public BigDecimal calculateTipShare(SplitParticipant splitParticipant, Split split) {
        return split.getTipAmount().multiply(splitParticipant.getTipShare());
    }

}
