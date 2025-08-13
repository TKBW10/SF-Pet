package com.pet.service.deviceInfo.strategy.deviceInfoProStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceThermostatMapper;
import com.pet.service.deviceInfo.strategy.DeviceInfoProStrategy;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceThermostatVo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ThermostatInfoProStrategyImpl implements DeviceInfoProStrategy {

    private final DeviceThermostatMapper deviceThermostatMapper;

    public ThermostatInfoProStrategyImpl(DeviceThermostatMapper deviceThermostatMapper) {
        this.deviceThermostatMapper = deviceThermostatMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.THERMOSTAT;
    }

    @Override
    public List<DeviceThermostatVo> getDeviceInfo(String roomId, String deviceId) {
        return Collections.singletonList(deviceThermostatMapper.selectInfoPro(roomId, deviceId));
    }
}
