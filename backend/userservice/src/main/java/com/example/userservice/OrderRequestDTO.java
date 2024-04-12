package com.example.userservice;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    private ObjectId bookId;
    private Integer quantity;

    // Constructor, getters, and setters
}