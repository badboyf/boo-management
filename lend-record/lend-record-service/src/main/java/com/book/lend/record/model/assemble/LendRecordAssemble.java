package com.book.lend.record.model.assemble;

import com.book.lend.record.dto.LendRecordDTO;
import com.book.lend.record.model.LendRecord;

public class LendRecordAssemble {
	public static LendRecordDTO assemble(LendRecord lendRecord) {
		LendRecordDTO lendRecordDTO = new LendRecordDTO();
		lendRecordDTO.setStatus(lendRecord.getStatus());
		lendRecordDTO.setId(lendRecord.getId());
		lendRecordDTO.setBookInfo(BookInfoAssemble.assemble(lendRecord.getBookInfo()));
		lendRecordDTO.setUserInfo(UserInfoAssemble.assemble(lendRecord.getUserInfo()));
		lendRecordDTO.setHistories(HistoryAssemble.assemble(lendRecord.getHistories()));
		lendRecordDTO.setCreateAt(lendRecord.getCreateAt());
		lendRecordDTO.setUpdateAt(lendRecord.getUpdateAt());

		return lendRecordDTO;
	}
}
