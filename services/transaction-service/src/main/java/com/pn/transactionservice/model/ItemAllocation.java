package com.pn.transactionservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ItemAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String itemAllocationId;

    // relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "split_participant_id", nullable = false)
    private SplitParticipant splitParticipant; // who this item allocation belongs to (Do we need this?)

    // reference to receipt service
    @Column(nullable = false)
    private String receiptItemId;

    // item metadata
    private String itemName;

    @Column(nullable = false)
    private BigDecimal itemPrice;

    @Column(nullable = false)
    private BigDecimal quantity;

    // allocation detail
    @Column(nullable = false, precision = 5, scale = 4)
    private BigDecimal splitPortion; // 0.5, 0.3, 1 (split in half, in three, pay for themselves)

    // actual amount this person owes for this item (item price * split portion + tax for item)
    // if not taxable then just item price * split portion
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal allocatedAmount;

    @Column(nullable = false)
    @Builder.Default
    private Boolean isTaxable = true;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal allocatedTax;

    private String notes;

    // audit
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;


}
