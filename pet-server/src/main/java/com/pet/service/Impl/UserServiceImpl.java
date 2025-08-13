package com.pet.service.Impl;

import com.pet.constant.LoginConstant;
import com.pet.dto.UpdatePasswordDto;
import com.pet.dto.UserDto;
import com.pet.entity.User;
import com.pet.mapper.UserMapper;
import com.pet.service.UserService;
import com.pet.utils.JwtBlacklistUtil;
import com.pet.utils.JwtUtil;
import com.pet.utils.PasswordEncryptor;
import com.pet.utils.PhoneIdGenerator;
import com.pet.vo.UserLoginVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final JwtBlacklistUtil jwtBlacklistUtil;

    public UserServiceImpl(UserMapper userMapper, JwtBlacklistUtil jwtBlacklistUtil) {
        this.userMapper = userMapper;
        this.jwtBlacklistUtil = jwtBlacklistUtil;
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
        System.out.println(user);
        if (user == null) {
            return LoginConstant.ACCOUNT_NOT_EXIST;
        }
        if (PasswordEncryptor.matches(userDto.getPassword(), user.getPassword())) {
            UserLoginVo userLoginVo = new UserLoginVo();
            userLoginVo.setUserId(user.getUserId());
            userLoginVo.setUsername(user.getUsername());
            userLoginVo.setToken(JwtUtil.generateToken(Map.of("userId", user.getUserId())));
            return userLoginVo;
        }
        return LoginConstant.PASSWORD_ERROR;
    }

    @Override
    public void logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && !token.isEmpty()) {
            jwtBlacklistUtil.addToBlacklist(token);
        }
    }

    @Override
    public Boolean updatePassword(UpdatePasswordDto updatePasswordDto) {
        String oldPassword = userMapper.selectPassword(updatePasswordDto.getPhoneNumber());
        if (!PasswordEncryptor.matches(updatePasswordDto.getOldPassword(), oldPassword)) {
            return false;
        }
        String newPassword = PasswordEncryptor.encrypt(updatePasswordDto.getNewPassword());
        return userMapper.updatePassword(updatePasswordDto.getPhoneNumber(), newPassword);
    }

//    @Override
//    public void delete() {
//        userMapper.delete();
//    }
}
