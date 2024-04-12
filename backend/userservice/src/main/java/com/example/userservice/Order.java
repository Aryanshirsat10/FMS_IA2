package com.example.userservice;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
public class Order {
    @Id
    private ObjectId id;
    private ObjectId userId;
    private List<ObjectId> bookIds;

    // Constructors, getters, and setters
    public Order(){
        
    }
    public Order(ObjectId userId, List<ObjectId> bookIds) {
        this.userId = userId;
        this.bookIds = bookIds;
    }

    // Getters and setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public List<ObjectId> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<ObjectId> bookIds) {
        this.bookIds = bookIds;
    }
}