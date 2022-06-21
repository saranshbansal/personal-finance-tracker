package com.banking.financeapp.web;

import com.banking.financeapp.domain.entity.Metadata;
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
	 *
	 * @return list of all metadata
	 */
	@Operation(summary = "Api to show all metadata")
	@GetMapping("/")
	public ResponseEntity<List<Metadata>> showMetadata() {
		return ResponseEntity.ok(metadataService.showMetadata());
	}

	/**
	 *
	 * @param metadata instance of {@link Metadata}
	 * @return 201 if created successfully
	 */
	@Operation(summary = "Api to creating new metadata")
	@PostMapping("/")
	public ResponseEntity<String> createMetadata(@RequestBody Metadata metadata) {
		log.info("Creating new metadata {}", metadata);
		metadataService.createMetadata(metadata);
		return new ResponseEntity<>(CREATED);
	}
}
