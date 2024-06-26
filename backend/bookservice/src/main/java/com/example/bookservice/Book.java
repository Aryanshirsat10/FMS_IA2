package com.example.bookservice;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    
    @Id
    private ObjectId id;

    private int bookId;
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
