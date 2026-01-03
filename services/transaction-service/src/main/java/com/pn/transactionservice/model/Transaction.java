package com.pn.transactionservice.model;

import com.pn.transactionservice.model.enummodel.PaymentMethod;
import com.pn.transactionservice.model.enummodel.TransactionStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "split_id", nullable = false)
    private Split split;

    // payment details
    @Column(nullable = false)
    private String fromUserId; // who owes

    @Column(nullable = false)
    private String toUserId; // who is owed

    @Column(nullable = false)
    private BigDecimal amount; // represents the amount the ower needs to pay the payer

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    @Builder.Default
    private TransactionStatus status = TransactionStatus.PENDING; // pending, requested, completed, cancelled

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private PaymentMethod paymentMethod; // venmo, cash, etc -> mostly would be through venmo or zelle

    private String externalPaymentId; // this is for when the application able to connect with venmo

    private String paymentUrl;

    private String description; // ex: payment for Cost co grocery

    private String notes; // when the person who owed pay the money note ex. thank you for going to the getting the grocery

    // audit
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime paymentRequestedAt;

    private LocalDateTime completedAt;

    private LocalDateTime cancelledAt;
}
