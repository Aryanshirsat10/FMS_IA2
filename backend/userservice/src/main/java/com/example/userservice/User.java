package com.example.userservice;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;
    private String email; // Changed from username to email
    private String password; // Consider using bcrypt for password hashing

    private List<Order> orders;

// Getters and setters for orders
public List<Order> getOrders() {
    return orders;
}

public void setOrders(List<Order> orders) {
    this.orders = orders;
}
}
