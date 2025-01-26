package com.cauegrassi.financetracker.service;

import com.cauegrassi.financetracker.dto.TransactionRequestDTO;
import com.cauegrassi.financetracker.dto.TransactionResponseDTO;
import com.cauegrassi.financetracker.entity.TransactionEntity;
import com.cauegrassi.financetracker.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
