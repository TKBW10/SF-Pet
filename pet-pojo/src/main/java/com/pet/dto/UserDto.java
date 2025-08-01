package com.pet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String username;

    private String phoneNumber;

    private String password;

    //性别 0 女 1 男
    private String sex;
}