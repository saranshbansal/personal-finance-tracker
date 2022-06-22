package com.banking.financeapp.domain.entity;

import com.banking.financeapp.domain.AmountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pft_expense")
public class ExpenseEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;

	@Column(name = "amount")
	private Double amount;

	@ManyToOne
	@JoinColumn(name = "category")
	private MetadataEntity category;

	@Enumerated(STRING)
	@Column(name = "type", nullable = false)
	private AmountType type;

	@Column(name = "description")
	private String description;

	@Column(name = "is_recurring")
	private boolean isRecurring;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@Column(name = "created_dt", nullable = false, updatable = false)
	private LocalDateTime createdDate;
}
