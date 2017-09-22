package com.book.lend.record.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class LendRecordDTO {
	private String id;
	private UserInfoDTO userInfo;
	private BookInfoDTO bookInfo;
	private String status;
	private List<HistoryDTO> histories;

	private Date createAt;
	private Date updateAt;
}
