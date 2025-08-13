package com.pet.service.deviceInfo.strategy.deviceInfoStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceTemperatureMapper;
import com.pet.vo.deviceVo.DeviceInfoListVo;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceTemperatureVo;
import com.pet.service.deviceInfo.strategy.DeviceInfoStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemperatureInfoStrategyImpl implements DeviceInfoStrategy {

    private final DeviceTemperatureMapper deviceTemperatureMapper;

    public TemperatureInfoStrategyImpl(DeviceTemperatureMapper deviceTemperatureMapper) {
        this.deviceTemperatureMapper = deviceTemperatureMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.TEMPERATURE;
    }

    @Override
    public void fill(String roomId, DeviceInfoListVo deviceInfoListVo) {
        List<DeviceTemperatureVo> deviceTemperatureVoList = deviceTemperatureMapper.selectInfo(roomId);
        deviceInfoListVo.setDeviceTemperatureVoList(deviceTemperatureVoList);
    }
}
