package com.pet.vo.deviceVo.deviceInfoVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceHumidityVo {
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private Double humidity;
    private Boolean online;
}
