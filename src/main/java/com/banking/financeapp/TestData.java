package com.banking.financeapp;

import com.banking.financeapp.domain.entity.Expense;
import com.banking.financeapp.domain.entity.Metadata;

import java.util.List;

import static java.util.Arrays.asList;

public class TestData {

	public List<Expense> showExpenses() {
		return asList(Expense.builder()
				.amount(100d)
				.category(Metadata.builder().key("CAT1").build())
				.build(),
				Expense.builder()
				.amount(200d)
				.category(Metadata.builder().key("CAT2").build())
				.build());
	}
}
