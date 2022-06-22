package com.banking.financeapp.service;

import com.banking.financeapp.domain.dto.ExpenseDto;
import com.banking.financeapp.domain.dto.MetadataDto;
import com.banking.financeapp.domain.entity.ExpenseEntity;
import com.banking.financeapp.domain.entity.MetadataEntity;
import com.banking.financeapp.repository.ExpenseLogRepository;
import com.banking.financeapp.repository.MetadataRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@Slf4j
public class ExpenseLogService {
	public static final String DEFAULT_USER = "sbansal";
	@Autowired
	private ExpenseLogRepository expenseLogRepository;

	@Autowired
	private MetadataRepository metadataRepository;

	@Autowired
	private ModelMapper modelMapper;

	public void logExpense(ExpenseDto expenseDto) {
		ExpenseEntity expense = modelMapper.map(expenseDto, ExpenseEntity.class);
		String categoryKey = ofNullable(expenseDto.getCategory()).map(MetadataDto::getKey).orElse(null);

		expense.setCategory(getMetadataByKey(categoryKey));
		expense.setCreatedBy(DEFAULT_USER);
		expense.setCreatedDate(now());
		expenseLogRepository.save(expense);
	}

	private MetadataEntity getMetadataByKey(String categoryKey) {
		if (isBlank(categoryKey)) return null;
		return metadataRepository.findOneByKey(categoryKey).orElse(null);
	}

	public List<ExpenseDto> showExpenses() {
		List<ExpenseEntity> expenses = expenseLogRepository.findAll();
		return modelMapper.map(expenses, new TypeToken<List<ExpenseDto>>() {
		}.getType());
	}
}
