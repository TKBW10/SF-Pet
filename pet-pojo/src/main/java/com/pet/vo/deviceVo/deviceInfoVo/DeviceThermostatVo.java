package com.pet.vo.deviceVo.deviceInfoVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceThermostatVo {
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private Double currentTemperature;
    private Double targetTemperature;
    private String mode;
    private Integer speed;
    private Boolean sweep;
    private Boolean online;
}
