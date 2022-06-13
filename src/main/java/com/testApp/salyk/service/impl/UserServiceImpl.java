package com.testApp.salyk.service.impl;

import com.testApp.salyk.dao.UserRepo;
import com.testApp.salyk.mappers.UserMapper;
import com.testApp.salyk.models.dtos.UserDto;
import com.testApp.salyk.models.entity.User;
import com.testApp.salyk.models.responses.ErrorResponse;
import com.testApp.salyk.models.responses.OkResponse;
import com.testApp.salyk.service.CodeService;
import com.testApp.salyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class UserServiceImpl implements UserService {
  @Autowired
    UserRepo userRepo;
  @Autowired
  CodeService codeService;

    @Override
    public ResponseEntity<?> save(UserDto userDto) {
      User user =
              UserMapper
                      .INSTANCE
                      .mapToUser(userDto);

      if (Objects.isNull(userRepo.findByLogin(user.getLogin()))) {
        userRepo
                .save(user);
      } else {
        return new ResponseEntity<>(
                new ErrorResponse("Пользователь уже существует", null)
                , HttpStatus.CONFLICT);
      }

      return ResponseEntity.ok(
              UserMapper
                      .INSTANCE
                      .mapToUserDto(user));
    }

  @Override
  public ResponseEntity<?> sendCode(String login) {

    User user = userRepo.findByLogin(login);

    if (Objects.isNull(user)) {
      return new ResponseEntity<>(
              new ErrorResponse("Некорректный логин!", null)
              , HttpStatus.NOT_FOUND);
    }

    codeService.sendCode(
            UserMapper
                    .INSTANCE
                    .mapToUserDto(user));

    return ResponseEntity.ok(
            new OkResponse("Код подтверждения успешно отправлен!", null));
  }

}

