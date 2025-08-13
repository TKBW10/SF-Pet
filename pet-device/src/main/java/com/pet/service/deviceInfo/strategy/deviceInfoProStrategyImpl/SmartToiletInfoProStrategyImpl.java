package com.pet.service.deviceInfo.strategy.deviceInfoProStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceSmartToiletMapper;
import com.pet.service.deviceInfo.strategy.DeviceInfoProStrategy;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceSmartToiletVo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class SmartToiletInfoProStrategyImpl implements DeviceInfoProStrategy {

    private final DeviceSmartToiletMapper deviceSmartToiletMapper;

    public SmartToiletInfoProStrategyImpl(DeviceSmartToiletMapper deviceSmartToiletMapper) {
        this.deviceSmartToiletMapper = deviceSmartToiletMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.SMART_TOILET;
    }

    @Override
    public List<DeviceSmartToiletVo> getDeviceInfo(String roomId, String deviceId) {
        return Collections.singletonList(deviceSmartToiletMapper.selectInfoPro(roomId, deviceId));
    }
}
