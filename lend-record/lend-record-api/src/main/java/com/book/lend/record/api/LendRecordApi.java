package com.book.lend.record.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.lend.record.dto.LendRecordDTO;

@RequestMapping(value = "/lendRecord")
public interface LendRecordApi {
	@RequestMapping(value = "/lend")
	public void lend(@RequestBody LendRecordDTO lendRecordDTO);

	@RequestMapping()
	public void getRecords(@RequestParam("userId") String userId, @RequestParam("bookId") String bookId);

	@RequestMapping(value = "/giveBack")
	public void giveBack(@RequestBody LendRecordDTO lendRecordDTO);
}
