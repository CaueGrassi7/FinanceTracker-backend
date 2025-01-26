package com.cauegrassi.financetracker.controller;

import com.cauegrassi.financetracker.dto.TransactionRequestDTO;
import com.cauegrassi.financetracker.dto.TransactionResponseDTO;
import com.cauegrassi.financetracker.repository.TransactionRepository;
import com.cauegrassi.financetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> createTransaction(@RequestBody TransactionRequestDTO transactionRequest) {
        transactionService.createTransaction(transactionRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> getTransactionById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }
}
