package com.pet.service;

import com.pet.dto.UserDto;

public interface UserService {
    Boolean register(UserDto userDto);

    Object login(UserDto userDto);
}
