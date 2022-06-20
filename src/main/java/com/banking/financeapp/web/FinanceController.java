package com.banking.financeapp.web;

import com.banking.financeapp.TestData;
import com.banking.financeapp.domain.entity.Expense;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/v1/finance")
public class FinanceController {

	/**
	 *
	 * @return list of all expenses
	 */
	@Operation(summary = "Api to show all expense")
	@GetMapping("/expenses")
	public ResponseEntity<List<Expense>> showExpenses() {
		TestData testData = new TestData();
		return ResponseEntity.ok(testData.showExpenses());
	}

	/**
	 *
	 * @param expense instance of {@link Expense}
	 * @return 201 if created successfully
	 */
	@Operation(summary = "Api to log an expense")
	@PostMapping("/expense")
	public ResponseEntity<String> logExpense(@RequestBody Expense expense) {
		log.info("Logging expense {}", expense);
		return new ResponseEntity<>(CREATED);
	}
}
