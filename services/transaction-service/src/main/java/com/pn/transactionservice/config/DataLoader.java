package com.pn.transactionservice.config;

import com.pn.transactionservice.model.Split;
import com.pn.transactionservice.model.SplitParticipant;
import com.pn.transactionservice.model.enummodel.PaymentStatus;
import com.pn.transactionservice.repository.ItemAllocationRepository;
import com.pn.transactionservice.repository.SplitParticipantRepository;
import com.pn.transactionservice.repository.SplitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Configuration
@Slf4j
@RequiredArgsConstructor
@Profile("dev")
public class DataLoader implements CommandLineRunner {

    private final SplitRepository splitRepository;
    private final ItemAllocationRepository itemAllocationRepository;
    private final SplitParticipantRepository splitParticipantRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("======================");
        log.info("Loading data...");
        log.info("======================");

        Split split = Split.builder()
                .receiptId("test-receipt_id")
                .payerId("Alice")
                .totalAmount(new BigDecimal("45.00"))
                .subtotal(new BigDecimal("40.00"))
                .tipAmount(new BigDecimal("3.00"))
                .description("test description")
                .build();

        split = splitRepository.save(split);

        SplitParticipant alice = SplitParticipant.builder()
                .split(split)
                .isPayer(true)
                .tipShare(new BigDecimal("0.33"))
                .paymentStatus(PaymentStatus.PAID)
                .createdAt(LocalDateTime.now())
                .build();

        alice = splitParticipantRepository.save(alice);

        log.info("======================");
        log.info("Data loaded successfully");
        log.info("======================");

    }
}
