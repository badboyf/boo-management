package com.book.lend.record.model.repsitory;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.book.lend.record.model.LendRecord;

public interface LendRecordRepository extends MongoRepository<LendRecord, String> {

}
