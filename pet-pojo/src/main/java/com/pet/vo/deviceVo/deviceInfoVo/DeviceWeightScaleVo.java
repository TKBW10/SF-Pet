package com.pet.vo.deviceVo.deviceInfoVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceWeightScaleVo {
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private Double weight;
    private Double change;
    private LocalDateTime createTime;
    private Boolean online;
}
