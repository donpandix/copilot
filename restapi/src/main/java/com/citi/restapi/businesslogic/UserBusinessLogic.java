package com.citi.restapi.businesslogic;

import com.citi.restapi.dto.UserDto;
import com.citi.restapi.dto.UserResponse;
import com.citi.restapi.model.UserModel;
import com.citi.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserBusinessLogic {

    private final UserRepository userRepository;

    @Autowired
    public UserBusinessLogic(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void consumeRandomUserApi() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://randomuser.me/api/?results=5000";

        ResponseEntity<UserResponse> responseEntity = restTemplate.getForEntity(url, UserResponse.class);
        UserResponse userResponse = responseEntity.getBody();

        // save to database with error control
        if (userResponse != null && userResponse.getResults() != null) {
            List<UserModel> userModelList = userResponse.getResults().stream()
                    .map(this::mapToUserModel)
                    .collect(Collectors.toList());
            userRepository.saveAll(userModelList);
        }
    }

    private UserModel mapToUserModel(UserDto userDto) {
        UserModel userModel = new UserModel();
        userModel.setTitle(userDto.getName().getTitle());
        userModel.setFirst(userDto.getName().getFirst());
        userModel.setLast(userDto.getName().getLast());
        userModel.setCity(userDto.getLocation().getCity());
        userModel.setState(userDto.getLocation().getState());
        userModel.setEmail(userDto.getEmail());
        userModel.setPhone(userDto.getPhone());
        userModel.setPicture(userDto.getPicture().getLarge());
        return userModel;
    }



}
