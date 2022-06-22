package com.banking.financeapp.service;

import com.banking.financeapp.domain.dto.MetadataDto;
import com.banking.financeapp.domain.entity.MetadataEntity;
import com.banking.financeapp.repository.MetadataRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Boolean.TRUE;
import static java.time.LocalDateTime.now;

@Service
@Slf4j
public class MetadataService {
	@Autowired
	private MetadataRepository metadataRepository;

	@Autowired
	private ModelMapper modelMapper;

	public void createMetadata(MetadataDto metadataDto) {
		MetadataEntity metadata = modelMapper.map(metadataDto, MetadataEntity.class);
		metadata.setCreatedDate(now());
		metadata.setActive(TRUE);
		metadataRepository.save(metadata);
	}

	public List<MetadataDto> showMetadata() {
		List<MetadataEntity> metadataEntities = metadataRepository.findAll();
		return modelMapper.map(metadataEntities, new TypeToken<List<MetadataDto>>() {
		}.getType());
	}
}
