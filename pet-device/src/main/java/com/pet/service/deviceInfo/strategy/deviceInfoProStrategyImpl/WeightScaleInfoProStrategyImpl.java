package com.pet.service.deviceInfo.strategy.deviceInfoProStrategyImpl;

import com.pet.constant.DeviceTypeConstants;
import com.pet.mapper.deviceMapper.DeviceWeightScaleMapper;
import com.pet.service.deviceInfo.strategy.DeviceInfoProStrategy;
import com.pet.vo.deviceVo.deviceInfoVo.DeviceWeightScaleVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeightScaleInfoProStrategyImpl implements DeviceInfoProStrategy {

    private final DeviceWeightScaleMapper deviceWeightScaleMapper;

    public WeightScaleInfoProStrategyImpl(DeviceWeightScaleMapper deviceWeightScaleMapper) {
        this.deviceWeightScaleMapper = deviceWeightScaleMapper;
    }

    @Override
    public String getType() {
        return DeviceTypeConstants.WEIGHT_SCALE;
    }

    @Override
    public List<DeviceWeightScaleVo> getDeviceInfo(String roomId, String deviceId) {
        return deviceWeightScaleMapper.selectInfoPro(roomId, deviceId);
    }
}
