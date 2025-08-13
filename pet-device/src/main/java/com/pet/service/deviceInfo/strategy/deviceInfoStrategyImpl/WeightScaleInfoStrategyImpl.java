package com.pet.service.deviceInfo.strategy.deviceInfoStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.HomeDeviceMapper;
import com.pet.mapper.deviceMapper.DeviceWeightScaleMapper;
import com.pet.vo.deviceVo.DeviceInfoListVo;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceWeightScaleVo;
import com.pet.service.deviceInfo.strategy.DeviceInfoStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeightScaleInfoStrategyImpl implements DeviceInfoStrategy {

    private final DeviceWeightScaleMapper deviceWeightScaleMapper;
    private final HomeDeviceMapper homeDeviceMapper;

    public WeightScaleInfoStrategyImpl(DeviceWeightScaleMapper deviceWeightScaleMapper, HomeDeviceMapper homeDeviceMapper) {
        this.deviceWeightScaleMapper = deviceWeightScaleMapper;
        this.homeDeviceMapper = homeDeviceMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.WEIGHT_SCALE;
    }

    @Override
    public void fill(String roomId, DeviceInfoListVo deviceInfoListVo) {
        List<DeviceWeightScaleVo> deviceWeightScaleVoList = deviceWeightScaleMapper.selectInfo(roomId);
        deviceWeightScaleVoList.forEach(deviceWeightScaleVo -> deviceWeightScaleVo.setOnline(homeDeviceMapper.selectOnline(roomId, deviceWeightScaleVo.getDeviceId())));
        deviceInfoListVo.setDeviceWeightScaleVoList(deviceWeightScaleVoList);
    }
}
