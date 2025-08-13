package com.pet.entity.device.deviceInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceThermostat {
    private Long id;
    private String userId;
    private String roomId;
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private Double currentTemperature;
    private Double targetTemperature;
    private String mode;
    private Integer speed;
    private Boolean sweep;
    private Boolean online;
    private LocalDateTime updateTime;
}
