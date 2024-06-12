package com.citi.restapi.dto;

import java.util.List;

public class UserResponse {

    private List<UserDto> results;

    public List<UserDto> getResults() {
        return results;
    }

    public void setResults(List<UserDto> results) {
        this.results = results;
    }

}
