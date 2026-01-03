package com.pn.transactionservice.repository;

import com.pn.transactionservice.model.Transaction;
import com.pn.transactionservice.model.enummodel.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySplitSplitId(String splitId);
    List<Transaction> findByFromUserId(String fromUserId);
    List<Transaction> findByToUserId(String toUserId);
    List<Transaction> findByStatus(TransactionStatus status);
}
