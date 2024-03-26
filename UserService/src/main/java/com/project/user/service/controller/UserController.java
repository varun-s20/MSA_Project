package com.project.user.service.controller;

import com.project.user.service.entity.User;
import com.project.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //create operation
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //read operation - get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //read operation - get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    //update operation
    @PutMapping("/{userId}")
    private ResponseEntity updateById(@PathVariable Long userId, @RequestBody User user){
        User updateUser = userService.updateUser(userId, user);
        return new ResponseEntity(updateUser, HttpStatus.OK);
    }

    //delete operation
    @DeleteMapping("/{userId}")
    public ResponseEntity deletebyId(@PathVariable("userId") Long userId){
        try{
            userService.deleteUser(userId);
        } catch (Exception exception)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Employee deleted with id: "+userId, HttpStatus.OK);
    }
}
