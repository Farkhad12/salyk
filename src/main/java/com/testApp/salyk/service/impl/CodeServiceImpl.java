package com.testApp.salyk.service.impl;

import com.testApp.salyk.dao.CodeRepo;
import com.testApp.salyk.mappers.CodeMapper;
import com.testApp.salyk.models.dtos.CodeDto;
import com.testApp.salyk.models.dtos.UserDto;
import com.testApp.salyk.models.entity.Code;
import com.testApp.salyk.service.CodeService;
import com.testApp.salyk.service.SendSimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Objects;
@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    private CodeRepo codeRepo;

    @Autowired
    private SendSimpleMessage sendMessage;

    @Override
    public void saveCode(CodeDto codeDto) {
        codeRepo.save(CodeMapper.INSTANCE.mapToCode(codeDto));
    }


    @Override
    public void sendCode(UserDto userDto) {
        int code = (int) ((Math.random() * 9000) + 1000);

        String hashedCode =
                BCrypt
                        .hashpw(
                                Integer
                                        .toString(code)
                                , BCrypt.gensalt());

        Calendar endOfCodeAction = Calendar.getInstance();
        endOfCodeAction.add(Calendar.MINUTE, 3);

        Code saveCode = new Code();
        saveCode.setCode(hashedCode);
        saveCode.setEndDate(endOfCodeAction.getTime());
        codeRepo.save(saveCode);

        sendMessage
                .sendSimpleMessage(
                        userDto.getEmail()
                        , Integer.toString(code));
    }
}
