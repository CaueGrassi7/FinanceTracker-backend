package com.cauegrassi.financetracker.dto;

import com.cauegrassi.financetracker.entity.TransactionEntity;
import com.cauegrassi.financetracker.entity.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponseDTO(
        Long id,
        String description,
        BigDecimal amount,
        TransactionType type,
        LocalDateTime createdAt
) {
    public TransactionResponseDTO(TransactionEntity transactionEntity) {
        this(transactionEntity.getId(), transactionEntity.getDescription(), transactionEntity.getAmount(),
                transactionEntity.getType(), transactionEntity.getDateTime());
    }
}
