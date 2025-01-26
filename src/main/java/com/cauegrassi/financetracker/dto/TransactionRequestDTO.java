package com.cauegrassi.financetracker.dto;

import com.cauegrassi.financetracker.entity.TransactionEntity;
import com.cauegrassi.financetracker.entity.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionRequestDTO(
        String description,
        BigDecimal amount,
        TransactionType type
) {
    public TransactionEntity toEntity() {
        return new TransactionEntity(
                description,
                amount,
                type,
                LocalDateTime.now()
        );
    }

}
