package com.jay.employee.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jay.employee.request.UserData;

@Repository
public interface AuthRepository extends MongoRepository<UserData, String> {

}
