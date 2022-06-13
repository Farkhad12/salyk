package com.testApp.salyk.service;

import com.testApp.salyk.models.dtos.CodeDto;
import com.testApp.salyk.models.dtos.UserDto;
import com.testApp.salyk.models.entity.Code;

public interface CodeService {
    void saveCode(CodeDto codeDto);

    void sendCode(UserDto userDto);
}
