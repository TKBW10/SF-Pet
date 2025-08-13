package com.pet.vo.deviceVo.deviceInfoVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceAirPurifierVo {
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private Double pm25;
    private Integer windSpeed;
    private Boolean anion;  // 负离子
    private String mode;
    private Double filter;  //滤网
    private Boolean online;
}
