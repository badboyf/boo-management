package com.book.lend.record.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.book.lend.record.model.vo.BookInfo;
import com.book.lend.record.model.vo.History;
import com.book.lend.record.model.vo.UserInfo;

import lombok.Data;

@Document(collection = "lendRecord")
@Data
public class LendRecord {
	@Id
	private String id;
	private UserInfo userInfo;
	private BookInfo bookInfo;
	private String status;
	private List<History> histories;

	private Date createAt;
	private Date updateAt;
}
