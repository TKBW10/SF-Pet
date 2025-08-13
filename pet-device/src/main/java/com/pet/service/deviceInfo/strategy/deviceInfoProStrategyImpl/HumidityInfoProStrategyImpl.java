package com.pet.service.deviceInfo.strategy.deviceInfoProStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceHumidityMapper;
import com.pet.service.deviceInfo.strategy.DeviceInfoProStrategy;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceHumidityVo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class HumidityInfoProStrategyImpl implements DeviceInfoProStrategy {

    private final DeviceHumidityMapper deviceHumidityMapper;

    public HumidityInfoProStrategyImpl(DeviceHumidityMapper deviceHumidityMapper) {
        this.deviceHumidityMapper = deviceHumidityMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.HUMIDITY;
    }

    @Override
    public List<DeviceHumidityVo> getDeviceInfo(String roomId, String deviceId) {
        return Collections.singletonList(deviceHumidityMapper.selectInfoPro(roomId, deviceId));
    }
}
