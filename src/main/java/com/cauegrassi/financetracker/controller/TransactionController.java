package com.cauegrassi.financetracker.controller;

import com.cauegrassi.financetracker.dto.SummaryResponseDTO;
import com.cauegrassi.financetracker.dto.TransactionRequestDTO;
import com.cauegrassi.financetracker.dto.TransactionResponseDTO;
import com.cauegrassi.financetracker.repository.TransactionRepository;
import com.cauegrassi.financetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactions() {
        List<TransactionResponseDTO> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/summary")
    public ResponseEntity<SummaryResponseDTO> getSummary() {
        var summary = transactionService.getSummary();
        return ResponseEntity.ok(summary);
    }
}
