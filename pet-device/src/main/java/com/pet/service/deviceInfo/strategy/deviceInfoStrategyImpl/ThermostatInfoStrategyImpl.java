package com.pet.service.deviceInfo.strategy.deviceInfoStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceThermostatMapper;
import com.pet.vo.deviceVo.DeviceInfoListVo;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceThermostatVo;
import com.pet.service.deviceInfo.strategy.DeviceInfoStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ThermostatInfoStrategyImpl implements DeviceInfoStrategy {

    private final DeviceThermostatMapper deviceThermostatMapper;

    public ThermostatInfoStrategyImpl(DeviceThermostatMapper deviceThermostatMapper) {
        this.deviceThermostatMapper = deviceThermostatMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.THERMOSTAT;
    }

    @Override
    public void fill(String roomId, DeviceInfoListVo deviceInfoListVo) {
        List<DeviceThermostatVo> deviceThermostatVoList = deviceThermostatMapper.selectInfo(roomId);
        deviceInfoListVo.setDeviceThermostatVoList(deviceThermostatVoList);
    }
}
