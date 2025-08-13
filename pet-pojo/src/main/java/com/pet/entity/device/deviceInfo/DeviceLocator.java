package com.pet.entity.device.deviceInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceLocator {
    private Long id;
    private String userId;
    private String roomId;
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private String petId;
    private Double latitude;
    private Double longitude;
    private LocalDateTime positionTime;
    private Boolean electronicFencing;
    private Boolean online;
    private LocalDateTime updateTime;
}
