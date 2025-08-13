package com.pet.entity.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeDevice {
    private Integer id;
    private String userId;
    private String roomId;
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private String online;
    private String ipAddress;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
