package com.pet.controller;

import com.pet.constant.LoginConstant;
import com.pet.dto.UpdatePasswordDto;
import com.pet.dto.UserDto;
import com.pet.result.Result;
import com.pet.service.UserService;
import com.pet.vo.UserLoginVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

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
            System.out.println(result);
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

    @GetMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        userService.logout(request);
        return Result.success();
    }

    @PostMapping("/updatePassword")
    public Result<String> updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto){
        Boolean success = userService.updatePassword(updatePasswordDto);
        if (success.equals(Boolean.TRUE)) {
            return Result.success();
        }
        return Result.error("修改失败");
    }

//    @PostMapping("/delete")
//    public Result<String> delete(){
//        userService.delete();
//        return Result.success();
//    }
}