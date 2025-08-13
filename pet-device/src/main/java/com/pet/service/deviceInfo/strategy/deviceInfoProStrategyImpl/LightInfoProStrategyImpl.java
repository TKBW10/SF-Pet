package com.pet.service.deviceInfo.strategy.deviceInfoProStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceLightMapper;
import com.pet.service.deviceInfo.strategy.DeviceInfoProStrategy;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceLightVo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class LightInfoProStrategyImpl implements DeviceInfoProStrategy {

    private final DeviceLightMapper deviceLightMapper;

    public LightInfoProStrategyImpl(DeviceLightMapper deviceLightMapper) {
        this.deviceLightMapper = deviceLightMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.LIGHT;
    }

    @Override
    public List<DeviceLightVo> getDeviceInfo(String roomId, String deviceId) {
        return Collections.singletonList(deviceLightMapper.selectInfoPro(roomId, deviceId));
    }
}
