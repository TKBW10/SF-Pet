package com.pet.controller;

import com.pet.constant.LoginConstant;
import com.pet.dto.UserDto;
import com.pet.result.Result;
import com.pet.service.UserService;
import com.pet.vo.UserLoginVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Result<String> register(@RequestBody UserDto userDto) {
        Boolean success = userService.register(userDto);
        if (success.equals(Boolean.TRUE)) {
            return Result.success();
        }
        return Result.error("注册失败");
    }

    @PostMapping("/login")
    public Result<UserLoginVo> login(@RequestBody UserDto userDto){
        Object result = userService.login(userDto);
        if (result instanceof UserLoginVo) {
            return Result.success((UserLoginVo) result);
        }
        if (result instanceof String) {
            if (result.equals(LoginConstant.ACCOUNT_NOT_EXIST)) {
                return Result.error(LoginConstant.ACCOUNT_NOT_EXIST);
            }
            if (result.equals(LoginConstant.PASSWORD_ERROR)) {
                return Result.error(LoginConstant.PASSWORD_ERROR);
            }
        }
        return Result.error(LoginConstant.LOGIN_ERROR);
    }
}