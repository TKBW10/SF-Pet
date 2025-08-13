package com.pet.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetVo {
    private String petId;
    private String petName;
    private String species;          // 种类
    private String breed;            // 品种
    private String gender;
    private LocalDate birthDate;
    private Double weight;
    private String avatarUrl;
    private String healthStatus;
}