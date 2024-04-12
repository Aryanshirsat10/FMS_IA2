package com.example.userservice;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, ObjectId> {
    List<Order> findByUserId(ObjectId userId);
}

