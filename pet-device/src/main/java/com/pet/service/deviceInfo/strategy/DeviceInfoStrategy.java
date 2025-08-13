package com.pet.service.deviceInfo.strategy;

import com.pet.vo.deviceVo.DeviceInfoListVo;

public interface DeviceInfoStrategy {
    String getType();
    void fill(String roomId, DeviceInfoListVo deviceInfoListVo);
}
