package com.pet.vo.deviceVo.deviceInfoVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceWaterDispenserVo {
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private Double waterLevel;
    private Double temperature;
    private Integer flow;
    private Double filter;
    private LocalDateTime lastRefillTime;
    private Boolean online;
}
