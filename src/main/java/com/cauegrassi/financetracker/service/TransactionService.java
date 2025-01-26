package com.cauegrassi.financetracker.service;

import com.cauegrassi.financetracker.dto.SummaryResponseDTO;
import com.cauegrassi.financetracker.dto.TransactionRequestDTO;
import com.cauegrassi.financetracker.dto.TransactionResponseDTO;
import com.cauegrassi.financetracker.entity.TransactionEntity;
import com.cauegrassi.financetracker.entity.enums.TransactionType;
import com.cauegrassi.financetracker.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void createTransaction(TransactionRequestDTO transactionRequest) {
        transactionRepository.save(transactionRequest.toEntity());
    }

    public TransactionResponseDTO getTransactionById(Long id) {
        TransactionEntity transactionEntity = transactionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Transaction not found")
        );
        return new TransactionResponseDTO(transactionEntity);
    }

    public List<TransactionResponseDTO> getAllTransactions() {
        var transactions = transactionRepository.findAll();
        return transactions.stream().map(TransactionResponseDTO::new).toList();
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public SummaryResponseDTO getSummary() {
        var transactions = transactionRepository.findAll();
        BigDecimal totalIncome = transactions.stream()
                .filter(transaction -> transaction.getType() == TransactionType.INCOME)
                .map(TransactionEntity::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalExpense = transactions.stream()
                .filter(transaction -> transaction.getType() == TransactionType.EXPENSE)
                .map(TransactionEntity::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal balence = totalIncome.subtract(totalExpense);
        return new SummaryResponseDTO(totalIncome, totalExpense, balence);
    }
}
