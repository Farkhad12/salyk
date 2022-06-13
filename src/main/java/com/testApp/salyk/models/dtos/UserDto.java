package com.testApp.salyk.models.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto{
    String name;
    String lastName;
    String email;
    String login;
    String password;

}
