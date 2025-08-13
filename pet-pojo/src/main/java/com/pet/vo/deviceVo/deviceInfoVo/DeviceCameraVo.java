package com.pet.vo.deviceVo.deviceInfoVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceCameraVo {
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private Long petId;
    private Long roomId;
    private Boolean online;
    private String lastSnapshotUrl;
    private LocalDateTime snapshotTime;
}
