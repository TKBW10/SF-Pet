package com.pet.entity.device.deviceInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceWaterDispenser {
    private Long id;
    private String userId;
    private String roomId;
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private Double waterLevel;
    private Double temperature;
    private Integer flow;
    private Double filter;
    private LocalDateTime lastRefillTime;
    private Boolean online;
    private LocalDateTime updateTime;
}
