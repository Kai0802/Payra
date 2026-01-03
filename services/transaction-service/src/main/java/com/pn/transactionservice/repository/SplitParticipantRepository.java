package com.pn.transactionservice.repository;

import com.pn.transactionservice.model.Split;
import com.pn.transactionservice.model.SplitParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SplitParticipantRepository extends JpaRepository<SplitParticipant, Long> {
    List<SplitParticipant> findBySplitSplitId(String splitSplitId);
    List<SplitParticipant> findByUserId(String userId);
}