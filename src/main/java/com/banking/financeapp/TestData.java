package com.banking.financeapp;

import com.banking.financeapp.domain.Expense;

import java.util.List;

import static java.util.Arrays.asList;

public class TestData {

	public List<Expense> showExpenses() {
		return asList(Expense.builder().amount(100).category("A").build(), Expense.builder().amount(200).category("B").build());
	}
}
