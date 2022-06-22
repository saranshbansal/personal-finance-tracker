package com.banking.financeapp.repository;

import com.banking.financeapp.domain.entity.MetadataEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MetadataRepository extends JpaRepository<MetadataEntity, UUID> {
	Optional<MetadataEntity> findOneByKey(@Value("key") String key);
}
