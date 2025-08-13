package com.pet.vo.deviceVo.deviceInfoVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceTemperatureVo {
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private Double temperature;
    private Boolean online;
}
