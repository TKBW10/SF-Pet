package com.pet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {
    private String roomId;
    private String petName;
    private String species;          // 种类
    private String breed;            // 品种
    private String gender;           // 性别
    private LocalDate birthDate;     // 出生日期
    private String avatarUrl;        // 宠物头像 URL
}
