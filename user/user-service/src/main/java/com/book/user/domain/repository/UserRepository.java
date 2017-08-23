package com.book.user.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.book.user.domain.module.User;

public interface UserRepository extends MongoRepository<User, String>, UserCustormRepository {

}
