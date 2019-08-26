package com.jay.employee.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jay.employee.request.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
