package com.banking.financeapp.service;

import com.banking.financeapp.domain.entity.Metadata;
import com.banking.financeapp.repository.MetadataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MetadataService {
	@Autowired
	private MetadataRepository metadataRepository;

	public Metadata createMetadata(Metadata metadata) {
		return metadataRepository.save(metadata);
	}

	public List<Metadata> showMetadata() {
		return metadataRepository.findAll();
	}
}
