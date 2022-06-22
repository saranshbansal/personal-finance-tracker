package com.banking.financeapp.domain.dto;

import com.banking.financeapp.domain.AmountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {
	private Double amount;
	private MetadataDto category;
	private AmountType type;
	private String description;
	private boolean isRecurring;
}
