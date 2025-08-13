package com.pet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private Long id;
    private String userId;
    private String roomId;
    private String petId;
    private String petName;
    private String species;          // 种类
    private String breed;            // 品种
    private String gender;           // 性别
    private LocalDate birthDate;     // 出生日期
    private Double weight;           // 当前体重（kg）
    private String avatarUrl;        // 宠物头像 URL
    private String healthStatus;     // 健康状态（如健康、过重、虚弱等）
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
