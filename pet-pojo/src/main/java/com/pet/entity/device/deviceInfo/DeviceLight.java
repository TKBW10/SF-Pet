package com.pet.entity.device.deviceInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceLight {
    private Long id;
    private String userId;
    private String roomId;
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private Boolean online;
    private Integer brightness;
    private Integer colorTem;
    private String color;
    private LocalDateTime updateTime;
}
