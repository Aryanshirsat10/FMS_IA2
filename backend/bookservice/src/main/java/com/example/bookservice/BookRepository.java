package com.example.bookservice;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

@Repository
public interface BookRepository extends MongoRepository<Book, ObjectId> {
    Optional<Book> findBookById(ObjectId id);
    @Query("{'_id': ?0}")
    void updateQuantity(ObjectId id, Integer quantity);
}

