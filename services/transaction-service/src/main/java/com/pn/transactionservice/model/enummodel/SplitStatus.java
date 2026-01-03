package com.pn.transactionservice.model.enummodel;

public enum SplitStatus {
    COMPLETED, // All payment receive
    PENDING, // Just created, calculation is not done
    CANCELLED, // Abandoned/deleted
    CALCULATED, // Math done, awaiting confirmation
    FINALIZED // Confirmed by payer, ready for payments
}
