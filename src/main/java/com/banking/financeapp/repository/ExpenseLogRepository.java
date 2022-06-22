package com.banking.financeapp.repository;

import com.banking.financeapp.domain.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExpenseLogRepository extends JpaRepository<ExpenseEntity, UUID> {
}
