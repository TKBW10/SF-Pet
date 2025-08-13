package com.pet.service.deviceInfo.strategy.deviceInfoStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceLightMapper;
import com.pet.vo.deviceVo.DeviceInfoListVo;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceLightVo;
import com.pet.service.deviceInfo.strategy.DeviceInfoStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LightInfoStrategyImpl implements DeviceInfoStrategy {

    private final DeviceLightMapper deviceLightMapper;

    public LightInfoStrategyImpl(DeviceLightMapper deviceLightMapper) {
        this.deviceLightMapper = deviceLightMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.LIGHT;
    }

    @Override
    public void fill(String roomId, DeviceInfoListVo deviceInfoListVo) {
        List<DeviceLightVo> deviceLightVoList = deviceLightMapper.selectInfo(roomId);
        deviceInfoListVo.setDeviceLightVoList(deviceLightVoList);
    }
}
