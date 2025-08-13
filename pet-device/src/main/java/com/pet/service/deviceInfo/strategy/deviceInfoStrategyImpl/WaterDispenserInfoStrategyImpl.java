package com.pet.service.deviceInfo.strategy.deviceInfoStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceWaterDispenserMapper;
import com.pet.vo.deviceVo.DeviceInfoListVo;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceWaterDispenserVo;
import com.pet.service.deviceInfo.strategy.DeviceInfoStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WaterDispenserInfoStrategyImpl implements DeviceInfoStrategy {

    private final DeviceWaterDispenserMapper deviceWaterDispenserMapper;

    public WaterDispenserInfoStrategyImpl(DeviceWaterDispenserMapper deviceWaterDispenserMapper) {
        this.deviceWaterDispenserMapper = deviceWaterDispenserMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.WATER_DISPENSER;
    }

    @Override
    public void fill(String roomId, DeviceInfoListVo deviceInfoListVo) {
        List<DeviceWaterDispenserVo> deviceWaterDispenserVoList = deviceWaterDispenserMapper.selectInfo(roomId);
        deviceInfoListVo.setDeviceWaterDispenserVoList(deviceWaterDispenserVoList);
    }
}
