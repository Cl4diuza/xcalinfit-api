package com.xcal.xcalinfit.entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelRepository extends MongoRepository<UserModel, String> {

	UserModel findByEmail(String email);

}