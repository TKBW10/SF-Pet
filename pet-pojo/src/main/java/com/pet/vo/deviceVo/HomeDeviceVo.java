package com.pet.vo.deviceVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeDeviceVo {
    private String roomId;
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private String deviceStatus;
    private String ipAddress;
}
