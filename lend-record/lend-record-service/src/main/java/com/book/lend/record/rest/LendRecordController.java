package com.book.lend.record.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.book.lend.record.api.LendRecordApi;
import com.book.lend.record.dto.LendRecordDTO;
import com.book.lend.record.model.LendRecord;
import com.book.lend.record.model.factory.LendRecordFactory;
import com.book.lend.record.model.repsitory.LendRecordRepository;

@RestController
public class LendRecordController implements LendRecordApi {
	@Autowired
	LendRecordRepository lendRecordRepository;

	@Override
	public void lend(LendRecordDTO lendRecordDTO) {
		LendRecord lendRecord = LendRecordFactory.factory(lendRecordDTO);
	}

	@Override
	public void getRecords(String userId, String bookId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void giveBack(LendRecordDTO lendRecordDTO) {
		// TODO Auto-generated method stub

	}

}
