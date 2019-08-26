package com.jay.employee.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jay.employee.response.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
