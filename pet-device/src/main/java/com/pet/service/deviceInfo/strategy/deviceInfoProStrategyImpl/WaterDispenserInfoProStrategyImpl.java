package com.pet.service.deviceInfo.strategy.deviceInfoProStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceWaterDispenserMapper;
import com.pet.service.deviceInfo.strategy.DeviceInfoProStrategy;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceWaterDispenserVo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class WaterDispenserInfoProStrategyImpl implements DeviceInfoProStrategy {

    private final DeviceWaterDispenserMapper deviceWaterDispenserMapper;

    public WaterDispenserInfoProStrategyImpl(DeviceWaterDispenserMapper deviceWaterDispenserMapper) {
        this.deviceWaterDispenserMapper = deviceWaterDispenserMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.WATER_DISPENSER;
    }

    @Override
    public List<DeviceWaterDispenserVo> getDeviceInfo(String roomId, String deviceId) {
        return Collections.singletonList(deviceWaterDispenserMapper.selectInfoPro(roomId, deviceId));
    }
}
