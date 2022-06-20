package com.banking.financeapp.web;

import com.banking.financeapp.domain.entity.Expense;
import com.banking.financeapp.service.ExpenseLogService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/v1/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseLogService expenseLogService;

	/**
	 *
	 * @return list of all expenses
	 */
	@Operation(summary = "Api to show all expense")
	@GetMapping("/")
	public ResponseEntity<List<Expense>> showExpenses() {
		return ResponseEntity.ok(expenseLogService.showExpenses());
	}

	/**
	 *
	 * @param expense instance of {@link Expense}
	 * @return 201 if created successfully
	 */
	@Operation(summary = "Api to log an expense")
	@PostMapping("/")
	public ResponseEntity<String> logExpense(@RequestBody Expense expense) {
		log.info("Logging expense {}", expense);
		expenseLogService.logExpense(expense);
		return new ResponseEntity<>(CREATED);
	}
}
