package com.citi.restapi.service;

import com.citi.restapi.model.UserModel;
import com.citi.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // method returns all the users from the database
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    // method to bring users paged
    public List<UserModel> getUsersPaged(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    // method to bring users sorted
    public List<UserModel> getUsersSorted(String field) {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    // method to add new user
    public UserModel addUser(UserModel user) {
        return userRepository.save(user);
    }

    // method to update user
    public UserModel updateUser(UserModel user) {
        return userRepository.save(user);
    }

    // method to delete user
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}
