package com.pet.service.deviceInfo.strategy.deviceInfoStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceHumidityMapper;
import com.pet.vo.deviceVo.DeviceInfoListVo;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceHumidityVo;
import com.pet.service.deviceInfo.strategy.DeviceInfoStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HumidityInfoStrategyImpl implements DeviceInfoStrategy {

    private final DeviceHumidityMapper deviceHumidityMapper;

    public HumidityInfoStrategyImpl(DeviceHumidityMapper deviceHumidityMapper) {
        this.deviceHumidityMapper = deviceHumidityMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.HUMIDITY;
    }

    @Override
    public void fill(String roomId, DeviceInfoListVo deviceInfoListVo) {
        List<DeviceHumidityVo> deviceHumidityVoList = deviceHumidityMapper.selectInfo(roomId);
        deviceInfoListVo.setDeviceHumidityVoList(deviceHumidityVoList);
    }
}
