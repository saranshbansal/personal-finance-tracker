package com.banking.financeapp;

import com.banking.financeapp.domain.entity.ExpenseEntity;
import com.banking.financeapp.domain.entity.MetadataEntity;

import java.util.List;

import static java.util.Arrays.asList;

public class TestData {

	public List<ExpenseEntity> showExpenses() {
		return asList(ExpenseEntity.builder()
				.amount(100d)
				.category(MetadataEntity.builder().key("CAT1").build())
				.build(),
				ExpenseEntity.builder()
				.amount(200d)
				.category(MetadataEntity.builder().key("CAT2").build())
				.build());
	}
}
