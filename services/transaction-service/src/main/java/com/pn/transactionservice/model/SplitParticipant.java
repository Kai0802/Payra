package com.pn.transactionservice.model;

import com.pn.transactionservice.model.enummodel.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
public class SplitParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String splitParticipantId;

    // this is a reference to the User table in the user service (hasn't been created)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "split_id", nullable = false)
    private Split split;

    @Column(nullable = false)
    private Boolean isPayer;

    // financial data
    @Column(precision = 10, scale = 2)
    private BigDecimal itemsSubtotal; // sum of all item allocations

    @Column(precision = 10, scale = 2)
    private BigDecimal taxShare; // share of tax

    @Column(precision = 10, scale = 2)
    private BigDecimal tipShare; // share of tip

    @Column(precision = 10, scale = 2)
    private BigDecimal totalOwed; // itemsSubtotal + tax share + tipshare

    // payment status
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    @Builder.Default
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    // relationship
    @OneToMany(mappedBy = "splitParticipant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemAllocation> itemAllocations;

    // audit info
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
