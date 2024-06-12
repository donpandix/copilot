package com.citi.restapi.controller;

import com.citi.restapi.businesslogic.UserBusinessLogic;
import com.citi.restapi.model.UserModel;
import com.citi.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
public class HomeController {

    private final UserService userService;

    private final UserBusinessLogic userBusinessLogic;


    @Autowired
    public HomeController(UserService userService, UserBusinessLogic userBusinessLogic) {
        this.userService = userService;
        this.userBusinessLogic = userBusinessLogic;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to Citi REST API";
    }

    @GetMapping("/users")
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }

    // method to bring users paged control the error showing a descriptive message
    @GetMapping("/users/paged")
    public List<UserModel> getUsersPaged(@RequestParam(required = false, defaultValue = "0") int page,
                                         @RequestParam(required = false, defaultValue = "10") int size) {
        return userService.getUsersPaged(page, size);
    }

    // method to bring users sorted
    @GetMapping("/users/sorted")
    public List<UserModel> getUsersSorted(String field) {
        return userService.getUsersSorted(field);
    }

    // method to add new user
    @GetMapping("/users/add")
    public UserModel addUser(UserModel user) {
        return userService.addUser(user);
    }

    // method to update user
    @GetMapping("/users/update")
    public UserModel updateUser(UserModel user) {
        return userService.updateUser(user);
    }

    // method to delete user
    @GetMapping("/users/delete")
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }

    // method add users from randomuser.me
    @GetMapping("/users/add/random")
    public void addRandomUsers() {
        userBusinessLogic.consumeRandomUserApi();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String message = "Invalid value '" + ex.getValue() + "' for parameter '" + ex.getName() + "'. Please provide a valid number.";
        return ResponseEntity.badRequest().body(message);
    }


}