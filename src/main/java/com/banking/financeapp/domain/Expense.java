package com.banking.financeapp.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Expense {
	double amount;
	String category;
}
