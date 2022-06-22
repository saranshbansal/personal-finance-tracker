package com.banking.financeapp.domain.dto;

import com.banking.financeapp.domain.MetaDataType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetadataDto {
	private String key;
	private String value;
	private MetaDataType dataType;
}
