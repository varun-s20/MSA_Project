package com.project.user.service.services;

import com.project.user.service.entity.User;

import java.util.List;

public interface UserService {

    //create operation
    User saveUser(User user);

    //read operation - get all user
    List<User> getAllUser();

    //read operation - get single user of given userId
    User getUser(Long userId);

    //update operation
    User updateUser(Long userId, User user);

    //delete operation
    void deleteUser(Long userId);
}
