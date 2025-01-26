package com.cauegrassi.financetracker.repository;

import com.cauegrassi.financetracker.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
