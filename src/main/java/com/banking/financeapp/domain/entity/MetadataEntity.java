package com.banking.financeapp.domain.entity;

import com.banking.financeapp.domain.MetaDataType;
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
@Table(name = "pft_metadata")
public class MetadataEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;

	@Column(name = "key", nullable = false, unique = true)
	private String key;

	@Column(name = "value", nullable = false, unique = true)
	private String value;

	@Column(name = "is_active", nullable = false)
	private boolean isActive;

	@Enumerated(STRING)
	@Column(name = "data_type", nullable = false)
	private MetaDataType dataType;

	@Column(name = "created_dt", nullable = false, updatable = false)
	private LocalDateTime createdDate;
}
