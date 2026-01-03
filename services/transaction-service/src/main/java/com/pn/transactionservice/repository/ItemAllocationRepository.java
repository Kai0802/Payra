package com.pn.transactionservice.repository;

import com.pn.transactionservice.model.ItemAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemAllocationRepository extends JpaRepository<ItemAllocation, Long> {
    List<ItemAllocation> findBySplitParticipantSplitParticipantId(String splitParticipantId);
}
