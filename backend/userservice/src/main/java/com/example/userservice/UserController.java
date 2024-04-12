package com.example.userservice;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User foundUser = userService.findUserByEmail(user.getEmail());
        if (foundUser != null) {
            // Perform password check here (consider using bcrypt)
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{userId}/order")
    public ResponseEntity<Order> createOrder(@PathVariable ObjectId userId,@RequestBody List<OrderRequestDTO> orderRequestDTOList) {
        List<ObjectId> bookIds = orderRequestDTOList.stream().map(OrderRequestDTO::getBookId).collect(Collectors.toList());
        List<Integer> quantities = orderRequestDTOList.stream().map(OrderRequestDTO::getQuantity).collect(Collectors.toList());
        Order order = userService.createOrder(userId, bookIds,quantities);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable ObjectId userId) {
        List<Order> orders = userService.getUserOrders(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
};
