package com.sales.sales.repository;

import com.sales.sales.model.SaleTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {
}