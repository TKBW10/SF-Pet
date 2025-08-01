package com.pet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    //唯一标识
    private String userId;

    private String username;

    private String phoneNumber;

    private String password;

    //性别 0 女 1 男
    private String sex;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}