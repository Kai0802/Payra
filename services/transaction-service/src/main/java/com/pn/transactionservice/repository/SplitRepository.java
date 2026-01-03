package com.pn.transactionservice.repository;

import com.pn.transactionservice.model.Split;
import com.pn.transactionservice.model.enummodel.SplitStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SplitRepository extends JpaRepository<Split, Long> {
    List<Split> findByPayerId(String payerId);
    List<Split> findByReceiptId(String receiptId);
    List<Split> findByStatus(SplitStatus splitStatus);
}
