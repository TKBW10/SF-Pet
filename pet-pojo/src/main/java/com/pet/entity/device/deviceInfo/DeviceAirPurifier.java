package com.pet.entity.device.deviceInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceAirPurifier {
    private Long id;
    private String userId;
    private String roomId;
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private Double pm25;
    private Integer windSpeed;
    private Boolean anion;  // 负离子
    private String mode;
    private Double filter;  //滤网
    private Boolean online;
    private LocalDateTime updateTime;
}
