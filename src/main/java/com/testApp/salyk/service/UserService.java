package com.testApp.salyk.service;

import com.testApp.salyk.models.dtos.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {


   public ResponseEntity<?> save(UserDto userDto);

    ResponseEntity<?> sendCode(String login);
}
