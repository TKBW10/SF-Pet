package com.pet.vo.deviceVo.deviceInfoVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceLightVo {
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private Boolean online;
    private Integer brightness;
    private Integer colorTem;
    private String color;
}
