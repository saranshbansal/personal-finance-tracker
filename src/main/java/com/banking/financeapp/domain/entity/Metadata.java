package com.banking.financeapp.domain.entity;

import com.banking.financeapp.domain.MetaDataType;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Data
@Builder
@Entity
@Table(name = "pft_metadata")
public class Metadata {

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
}
