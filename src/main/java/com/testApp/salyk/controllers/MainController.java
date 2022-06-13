package com.testApp.salyk.controllers;

import com.testApp.salyk.models.dtos.UserDto;
import com.testApp.salyk.models.entity.User;
import com.testApp.salyk.service.UserService;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/main")
public class MainController {
    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }
    @PostMapping("/sendCode")
    public ResponseEntity<?> sendCode(@RequestParam String login) {
        return userService.sendCode(login);
    }


}
