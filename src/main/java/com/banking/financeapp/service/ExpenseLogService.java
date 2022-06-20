package com.banking.financeapp.service;

import com.banking.financeapp.domain.entity.Expense;
import com.banking.financeapp.repository.ExpenseLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ExpenseLogService {
	@Autowired
	private ExpenseLogRepository expenseLogRepository;

	public Expense logExpense(Expense expense) {
		return expenseLogRepository.save(expense);
	}

	public List<Expense> showExpenses() {
		return expenseLogRepository.findAll();
	}
}
