package com.pet.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserHomeVo {
    private String roomId;
    private String roomName;
    private List<String> petName;
    private List<String> deviceName;
    private String temperature;
    private String humidity;
}
