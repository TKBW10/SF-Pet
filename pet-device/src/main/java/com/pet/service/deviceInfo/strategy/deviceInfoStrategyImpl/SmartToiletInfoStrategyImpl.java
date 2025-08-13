package com.pet.service.deviceInfo.strategy.deviceInfoStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceSmartToiletMapper;
import com.pet.vo.deviceVo.DeviceInfoListVo;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceSmartToiletVo;
import com.pet.service.deviceInfo.strategy.DeviceInfoStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SmartToiletInfoStrategyImpl implements DeviceInfoStrategy {

    private final DeviceSmartToiletMapper deviceSmartToiletMapper;

    public SmartToiletInfoStrategyImpl(DeviceSmartToiletMapper deviceSmartToiletMapper) {
        this.deviceSmartToiletMapper = deviceSmartToiletMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.SMART_TOILET;
    }

    @Override
    public void fill(String roomId, DeviceInfoListVo deviceInfoListVo) {
        List<DeviceSmartToiletVo> deviceSmartToiletVoList = deviceSmartToiletMapper.selectInfo(roomId);
        deviceInfoListVo.setDeviceSmartToiletVoList(deviceSmartToiletVoList);
    }
}
