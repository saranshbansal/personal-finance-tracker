package com.banking.financeapp.web;

import com.banking.financeapp.domain.dto.MetadataDto;
import com.banking.financeapp.service.MetadataService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/v1/metadata")
public class MetadataController {

	@Autowired
	private MetadataService metadataService;

	/**
	 * Show all metadata
	 *
	 * @return list of all metadata
	 */
	@Operation(summary = "Api to show all metadata")
	@GetMapping("/")
	public ResponseEntity<List<MetadataDto>> showMetadata() {
		return ResponseEntity.ok(metadataService.showMetadata());
	}

	/**
	 * Create a new matadata entry
	 *
	 * @param metadataDto instance of {@link MetadataDto}
	 * @return 201 if created successfully
	 */
	@Operation(summary = "Api to creating new metadata")
	@PostMapping("/")
	public ResponseEntity<String> createMetadata(@RequestBody MetadataDto metadataDto) {
		log.info("Creating new metadata {}", metadataDto);
		metadataService.createMetadata(metadataDto);
		return new ResponseEntity<>(CREATED);
	}
}
