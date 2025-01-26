package com.cauegrassi.financetracker.dto;

import java.math.BigDecimal;

public record SummaryResponseDTO(
        BigDecimal totalIncome,
        BigDecimal totalExpense,
        BigDecimal balence
) {
}
