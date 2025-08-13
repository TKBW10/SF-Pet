package com.pet.service.deviceInfo.strategy;

import java.util.List;

public interface DeviceInfoProStrategy {
    String getType();
    List<?> getDeviceInfo(String roomId, String deviceId);
}
