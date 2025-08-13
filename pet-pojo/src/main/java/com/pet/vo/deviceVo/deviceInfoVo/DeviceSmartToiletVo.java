package com.pet.vo.deviceVo.deviceInfoVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceSmartToiletVo {
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private String cleanStatus;
    private LocalDateTime lastCleanTime;
    private Boolean autoClear;
    private Boolean deodorization;
    private Double catLitter;
    private Boolean online;
}
