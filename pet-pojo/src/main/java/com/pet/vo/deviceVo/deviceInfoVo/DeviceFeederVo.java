package com.pet.vo.deviceVo.deviceInfoVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceFeederVo {
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private Double foodLevel;
    private String autoFeedTime;
    private Integer autoFeedWeight;
    private LocalDateTime lastFeedTime;
    private Boolean online;
}
