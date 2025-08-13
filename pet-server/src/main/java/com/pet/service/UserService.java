package com.pet.service;

import com.pet.dto.UpdatePasswordDto;
import com.pet.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    Boolean register(UserDto userDto);

    Object login(UserDto userDto);

    void logout(HttpServletRequest request);

    Boolean updatePassword(UpdatePasswordDto updatePasswordDto);

//    void delete();
}
