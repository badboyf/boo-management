package com.book.lend.record.model.factory;

import com.book.lend.record.dto.LendRecordDTO;
import com.book.lend.record.model.LendRecord;

public class LendRecordFactory {
	public static LendRecord factory(LendRecordDTO lendRecordDTO) {
		LendRecord lendRecord = new LendRecord();
		lendRecord.setStatus(lendRecordDTO.getStatus());
		lendRecord.setId(lendRecordDTO.getId());
		lendRecord.setBookInfo(BookInfoFactory.factory(lendRecordDTO.getBookInfo()));
		lendRecord.setUserInfo(UserInfoFactory.factory(lendRecordDTO.getUserInfo()));
		lendRecord.setHistories(HistoryFactory.factory(lendRecordDTO.getHistories()));
		

		return lendRecord;
	}
}
