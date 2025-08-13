package com.pet.service.deviceInfo.strategy.deviceInfoProStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceTemperatureMapper;
import com.pet.service.deviceInfo.strategy.DeviceInfoProStrategy;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceTemperatureVo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class TemperatureInfoProStrategyImpl implements DeviceInfoProStrategy {

    private final DeviceTemperatureMapper deviceTemperatureMapper;

    public TemperatureInfoProStrategyImpl(DeviceTemperatureMapper deviceTemperatureMapper) {
        this.deviceTemperatureMapper = deviceTemperatureMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.TEMPERATURE;
    }

    @Override
    public List<DeviceTemperatureVo> getDeviceInfo(String roomId, String deviceId) {
        return Collections.singletonList(deviceTemperatureMapper.selectInfoPro(roomId, deviceId));
    }
}
