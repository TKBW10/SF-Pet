package com.pet.service.Impl;

import com.pet.constant.LoginConstant;
import com.pet.dto.UserDto;
import com.pet.entity.User;
import com.pet.mapper.UserMapper;
import com.pet.service.UserService;
import com.pet.utils.JwtUtil;
import com.pet.utils.PasswordEncryptor;
import com.pet.utils.PhoneIdGenerator;
import com.pet.vo.UserLoginVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Boolean register(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setUserId(PhoneIdGenerator.generateId(userDto.getPhoneNumber()));
        user.setPassword(PasswordEncryptor.encrypt(userDto.getPassword()));
        return userMapper.insert(user);
    }

    @Override
    public Object login(UserDto userDto) {
        User user = userMapper.selectUser(userDto.getPhoneNumber());
        if (user == null) {
            return LoginConstant.ACCOUNT_NOT_EXIST;
        }
        if (PasswordEncryptor.matches(userDto.getPassword(), user.getPassword())) {
            UserLoginVo userLoginVo = new UserLoginVo();
            userLoginVo.setPhoneNumber(userDto.getPhoneNumber());
            userLoginVo.setToken(JwtUtil.generateToken(Map.of("phoneNumber", userDto.getPhoneNumber())));
            return userLoginVo;
        }
        return LoginConstant.PASSWORD_ERROR;
    }
}
