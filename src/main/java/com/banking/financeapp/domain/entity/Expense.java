package com.banking.financeapp.domain.entity;

import com.banking.financeapp.domain.AmountType;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Data
@Builder
@Entity
@Table(name = "pft_expense")
public class Expense {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;

	@Column(name = "amount")
	private Double amount;

	@ManyToOne
	@JoinColumn(name = "category")
	private Metadata category;

	@Enumerated(STRING)
	@Column(name = "type", nullable = false)
	private AmountType type;

	@Column(name = "description")
	private String description;

	@Column(name = "is_recurring")
	private boolean isRecurring;
}
