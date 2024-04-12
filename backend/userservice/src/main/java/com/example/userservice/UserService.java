package com.example.userservice;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    private RestTemplate restTemplate = new RestTemplate();
    

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Order createOrder(ObjectId userId, List<ObjectId> bookIds, List<Integer> quantities) {
        for (int i = 0; i < bookIds.size(); i++) {
            ObjectId bookId = bookIds.get(i);
            Integer quantity = quantities.get(i);
            // Call BookService to update the quantity
            String bookServiceUrl = "http://localhost:8081/books/" + bookId + "/quantity";
            restTemplate.put(bookServiceUrl, quantity);
        }
        // Create the order
        Order order = new Order(userId, bookIds);
        return orderRepository.save(order);
    }

    public List<Order> getUserOrders(ObjectId userId) {
        return orderRepository.findByUserId(userId);
    }
    
}