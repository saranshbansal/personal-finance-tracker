package com.banking.financeapp.web;

import com.banking.financeapp.TestData;
import com.banking.financeapp.domain.Expense;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceController {

	@Operation(summary = "Test api to write hello world")
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@Operation(summary = "Test api to show all expenses")
	@GetMapping("/expense")
	public List<Expense> getExpense() {
		TestData testData = new TestData();
		return testData.showExpenses();
	}
}
